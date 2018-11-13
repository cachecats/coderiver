package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 性别枚举类
 */
@Getter
public enum SexEnum {

    UNKNOW(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    ;

    private Integer code;

    private String msg;

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
