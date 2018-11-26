package com.solo.coderiver.comments.enums;

import lombok.Getter;

/**
 * 评论类型枚举
 */

public enum CommentsTypeEnum {
    USER(1, "用户评论"),
    PROJECT(2, "项目评论"),
    RESOURCE(3, "资源评论");

    private Integer code;

    private String msg;

    CommentsTypeEnum(Integer code, String msg) {
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
