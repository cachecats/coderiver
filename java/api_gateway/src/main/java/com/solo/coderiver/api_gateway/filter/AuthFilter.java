package com.solo.coderiver.api_gateway.filter;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.solo.coderiver.api_gateway.VO.ResultVO;
import com.solo.coderiver.api_gateway.consts.RedisConsts;
import com.solo.coderiver.api_gateway.utils.CookieUtils;
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
 * 验证权限 从 cookie 中取出token与数据库中的对比，不一致抛出无权限
 */
@Slf4j
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    private static final String LOGIN_URI = "/user/login";
    private static final String REGISTER_URI = "/user/register";

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

        //通过工具类从 Cookie 中取出 token
        Cookie tokenCookie = CookieUtils.getCookieByName(request, "token");
        if (tokenCookie == null || StringUtils.isEmpty(tokenCookie.getValue()) || !verifyToken(tokenCookie.getValue())) {
            readTokenFromHeader(requestContext, request);
        }

        return null;
    }

    /**
     * 从 header 中读取 token 并校验
     *
     * @param requestContext
     */
    private void readTokenFromHeader(RequestContext requestContext, HttpServletRequest request) {
        //先从 header 中读取，读到 cookie 则校验并跳过读 cookie
        String headerToken = request.getHeader("token");
        if (StringUtils.isEmpty(headerToken) || !verifyToken(headerToken)) {
            setUnauthorizedResponse(requestContext);
        }
    }

    /**
     * 从Redis中校验token
     *
     * @param token
     * @return
     */
    private boolean verifyToken(String token) {
        String result = stringRedisTemplate.opsForValue().get(String.format(RedisConsts.TOKEN_TEMPLATE, token));
        return !StringUtils.isEmpty(result);
    }

    /**
     * 设置 403 无权限状态
     *
     * @param requestContext
     */
    private void setUnauthorizedResponse(RequestContext requestContext) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        ResultVO vo = new ResultVO();
        vo.setCode(401);
        vo.setMsg("invalid token");
        Gson gson = new Gson();
        String result = gson.toJson(vo);

        requestContext.setResponseBody(result);
    }
}
