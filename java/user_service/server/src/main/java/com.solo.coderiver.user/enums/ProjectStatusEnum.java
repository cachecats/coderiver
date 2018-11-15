package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 项目状态的枚举
 */
@Getter
public enum ProjectStatusEnum {
    DEVELOPING(0, "开发中"),
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),

    ;

    private Integer code;

    private String msg;

    ProjectStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
