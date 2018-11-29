package com.solo.coderiver.project.enums;

import lombok.Getter;

@Getter
public enum ProjectMemberStatusEnum {
    UNMATCH(0, "未匹配"),
    MATCH(1, "匹配"),
    ;

    private Integer code;

    private String msg;

    ProjectMemberStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
