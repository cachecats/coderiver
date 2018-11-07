package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 组队申请的审核状态
 */
@Getter
public enum TeamApplyAuditStatusEnum {

    WAIT(0, "待审核"),
    PASS(1, "通过"),
    REJECT(2, "拒绝"),
    ;

    private Integer code;

    private String msg;

    TeamApplyAuditStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
