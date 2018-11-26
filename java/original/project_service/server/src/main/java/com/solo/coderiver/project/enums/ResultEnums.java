package com.solo.coderiver.project.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    PARAMS_ERROR(1, "参数错误"),
    NEW_PROJECT_FAIL(101, "新建项目失败，请稍后再试"),

    ;


    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
