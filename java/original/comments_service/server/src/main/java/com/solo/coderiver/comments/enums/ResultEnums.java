package com.solo.coderiver.comments.enums;

import lombok.Getter;


public enum ResultEnums {
    PARAMS_ERROR(1, "参数错误"),
    SAVE_COMMENTS_FAIL(120, "保存评论失败"),
    ;


    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
