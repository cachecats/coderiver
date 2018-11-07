package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 组队申请的状态
 */
@Getter
public enum TeamApplyStatusEnum {

    DELETE(0, "删除"),
    NORMAL(1, "正常"),
    ;

    private Integer code;

    private String msg;

    TeamApplyStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
