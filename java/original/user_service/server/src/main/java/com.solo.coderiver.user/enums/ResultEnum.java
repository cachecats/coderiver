package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 返回结果的枚举类
 */
@Getter
public enum ResultEnum {
    PARAMS_ERROR(1, "参数错误"),
    EMAIL_ALREADY_REGISTER(10, "该邮箱已被注册，直接登录吧"),
    REGISTER_FAIL(11, "注册失败，请重试"),
    EMAIL_PASSWORD_EMPTY(20, "邮箱或密码不能为空"),
    EMAIL_NOT_EXIST(21, "当前邮箱还未注册"),
    PASSWORD_ERROR(22, "密码不正确"),
    RESET_PASSWORD_FAIL(22, "密码修改失败，请稍后再试"),
    SAVE_EDUCATION_EXPERIENCE_FAIL(30, "保存教育经历失败"),
    FIND_EDUCATION_EXPERIENCE_FAIL(30, "没有找到该用户的教育经历"),
    USER_ID_CANNOT_EMPTY(30, "用户id不能为空"),
    MAIN_ID_NOT_NULL(31, "主键id不能为空"),
    SAVE_WORK_EXPERIENCE_FAIL(40, "保存工作经历失败"),
    PROJECT_ID_EMPTY(50, "项目id不能为空"),
    CANNOT_FIND_USER_INFO(60, "没有查询到用户信息"),
    CANNOT_FIND_PROJECT_INFO(61, "没有查询到项目信息"),
    LIKE_FAIL(70, "点赞失败"),
    UNLIKE_FAIL(70, "取消点赞失败"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
