package com.solo.coderiver.gateway.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.solo.coderiver.gateway.VO.ResultVO;
import com.solo.coderiver.gateway.consts.RedisConsts;
import com.solo.coderiver.gateway.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限验证 Filter
 * 注册和登录接口不过滤
 *
 * 验证权限需要前端在 Cookie 或 Header 中（二选一即可）设置用户的 userId 和 token
 * 因为 token 是存在 Redis 中的，Redis 的键由 userId 构成，值是 token
 * 在两个地方都没有找打 userId 或 token其中之一，就会返回 401 无权限，并给与文字提示
 */
@Slf4j
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //排除过滤的 uri 地址
    private static final String LOGIN_URI = "/user/login";
    private static final String REGISTER_URI = "/user/register";

    //无权限时的提示语
    private static final String INVALID_TOKEN = "invalid token";
    private static final String INVALID_USERID = "invalid userId";

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("uri:{}", request.getRequestURI());
        //注册和登录接口不拦截，其他接口都要拦截校验 token
        if (LOGIN_URI.equals(request.getRequestURI()) ||
                REGISTER_URI.equals(request.getRequestURI())) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //先从 cookie 中取 token，cookie 中取失败再从 header 中取，两重校验
        //通过工具类从 Cookie 中取出 token
        Cookie tokenCookie = CookieUtils.getCookieByName(request, "token");
        if (tokenCookie == null || StringUtils.isEmpty(tokenCookie.getValue())) {
            readTokenFromHeader(requestContext, request);
        } else {
            verifyToken(requestContext, request, tokenCookie.getValue());
        }

        return null;
    }

    /**
     * 从 header 中读取 token 并校验
     *
     * @param requestContext
     */
    private void readTokenFromHeader(RequestContext requestContext, HttpServletRequest request) {
        //从 header 中读取
        String headerToken = request.getHeader("token");
        if (StringUtils.isEmpty(headerToken)) {
            setUnauthorizedResponse(requestContext, INVALID_TOKEN);
        } else {
            verifyToken(requestContext, request, headerToken);
        }
    }

    /**
     * 从Redis中校验token
     *
     * @param token
     * @return
     */
    private void verifyToken(RequestContext requestContext, HttpServletRequest request, String token) {
        //需要从cookie或header 中取出 userId 来校验 token 的有效性，因为每个用户对应一个token，在Redis中是以 TOKEN_userId 为键的
        Cookie userIdCookie = CookieUtils.getCookieByName(request, "userId");
        if (userIdCookie == null || StringUtils.isEmpty(userIdCookie.getValue())) {
            //从header中取userId
            String userId = request.getHeader("userId");
            if (StringUtils.isEmpty(userId)) {
                setUnauthorizedResponse(requestContext, INVALID_USERID);
            } else {
                String redisToken = stringRedisTemplate.opsForValue().get(String.format(RedisConsts.TOKEN_TEMPLATE, userId));
                if (StringUtils.isEmpty(redisToken) || !redisToken.equals(token)) {
                    setUnauthorizedResponse(requestContext, INVALID_TOKEN);
                }
            }
        } else {
            String redisToken = stringRedisTemplate.opsForValue().get(String.format(RedisConsts.TOKEN_TEMPLATE, userIdCookie.getValue()));
            if (StringUtils.isEmpty(redisToken) || !redisToken.equals(token)) {
                setUnauthorizedResponse(requestContext, INVALID_TOKEN);
            }
        }
    }


    /**
     * 设置 401 无权限状态
     *
     * @param requestContext
     */
    private void setUnauthorizedResponse(RequestContext requestContext, String msg) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        ResultVO vo = new ResultVO();
        vo.setCode(401);
        vo.setMsg(msg);
        Gson gson = new Gson();
        String result = gson.toJson(vo);

        requestContext.setResponseBody(result);
    }


}
