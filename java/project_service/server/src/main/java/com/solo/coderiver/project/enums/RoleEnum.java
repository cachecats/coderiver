package com.solo.coderiver.project.enums;

import lombok.Getter;

/**
 * 角色枚举类
 */
@Getter
public enum RoleEnum {
    UNKNOW(0, "未知"),
    DESIGNER(1, "设计师"),
    FRONT_END(2, "前端工程师"),
    BACK_END(3, "后端工程师"),
    MOBILE(4, "移动端工程师"),
    GAME(5, "游戏工程师"),
    PRODUCT_MANAGER(6, "产品经理"),
    ;


    private Integer code;

    private String msg;

    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
