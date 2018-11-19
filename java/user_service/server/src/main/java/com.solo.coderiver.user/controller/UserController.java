package com.solo.coderiver.user.controller;

import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.VO.UserInfoVO;
import com.solo.coderiver.user.dto.ExperienceDTO;
import com.solo.coderiver.user.dto.RoleDTO;
import com.solo.coderiver.user.dto.UserInfoDTO;
import com.solo.coderiver.user.enums.ResultEnum;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.form.RegisterForm;
import com.solo.coderiver.user.service.LikedService;
import com.solo.coderiver.user.service.RedisService;
import com.solo.coderiver.user.service.UserService;
import com.solo.coderiver.user.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@Api(description = "用户服务")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LikedService likedService;

    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/register")
    @ApiOperation(value = "通过邮箱注册用户")
    public ResultVO registerByEmail(@Valid RegisterForm form, BindingResult bindingResult) {
        //校验不通过
        if (bindingResult.hasErrors()) {
            log.error("【用户注册】参数错误，form=${}", form.toString());
            throw new UserException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        UserInfoDTO dto = new UserInfoDTO();
        BeanUtils.copyProperties(form, dto);
        userService.registerByEmail(dto);

        return ResultVOUtils.success();
    }

    @ApiOperation(value = "通过邮箱登录")
    @PostMapping("/login")
    public ResultVO loginByEmail(@RequestParam("email") String email,
                                 @RequestParam("password") String password) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new UserException(ResultEnum.EMAIL_PASSWORD_EMPTY);
        }
        UserInfoDTO dto = userService.loginByEmail(email, password);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(dto, userInfoVO);

        return ResultVOUtils.success(userInfoVO);
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/reset")
    public ResultVO resetPassword(@RequestParam("id") String id,
                                  @RequestParam("oldPassword") String oldPassword,
                                  @RequestParam("newPassword") String newPassword) {
        userService.resetPassword(id, oldPassword, newPassword);
        return ResultVOUtils.success();
    }

    @GetMapping("/get-roles")
    @ApiOperation("获取所有的用户角色")
    public ResultVO getAllRoles() {
        List<RoleDTO> allRoles = userService.findAllRoles();
        return ResultVOUtils.success(allRoles);
    }

    @GetMapping("/get-experiences")
    @ApiOperation("获取所有工作经验")
    public ResultVO getAllExperience(){
        List<ExperienceDTO> allExperience = userService.findAllExperience();
        return ResultVOUtils.success(allExperience);
    }

    @PostMapping("/like")
    @ApiOperation("点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "likedUserId", value = "被点赞的用户id"),
            @ApiImplicitParam(name = "likedPostId", value = "点赞的用户id")
    })
    public ResultVO like(@RequestParam("likedUserId") String likedUserId,
                         @RequestParam("likedPostId") String likedPostId) {
        //先把数据存到Redis里,再定时存回数据库
        redisService.saveLiked2Redis(likedUserId, likedPostId);
        redisService.incrementLikedCount(likedUserId);
        return ResultVOUtils.success();
    }

    @PostMapping("/unlike")
    @ApiOperation("取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "likedUserId", value = "被点赞的用户id"),
            @ApiImplicitParam(name = "likedPostId", value = "点赞的用户id")
    })
    public ResultVO unlike(@RequestParam("likedUserId") String likedUserId,
                           @RequestParam("likedPostId") String likedPostId) {
        //取消点赞,先存到Redis里面，再定时写到数据库里
        redisService.unlikeFromRedis(likedUserId, likedPostId);
        redisService.decrementLikedCount(likedUserId);
        return ResultVOUtils.success();
    }


    @GetMapping("/test")
    @ApiOperation("接口测试")
    public String test() {
        return "hello coderiver";
    }
}
