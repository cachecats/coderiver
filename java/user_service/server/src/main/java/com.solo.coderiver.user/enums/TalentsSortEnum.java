package com.solo.coderiver.user.enums;

import lombok.Getter;

@Getter
public enum TalentsSortEnum {
    DEFAULT(0, "默认排序"),
    SORT_BY_INFLUENCE(1, "根据影响力排序"),
    SORT_BY_EXPERIENCE(2, "根据经验排序"),
    ;

    private Integer code;

    private String msg;

    TalentsSortEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
