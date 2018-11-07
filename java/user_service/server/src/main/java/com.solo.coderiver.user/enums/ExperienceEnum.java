package com.solo.coderiver.user.enums;

import lombok.Getter;

/**
 * 工作经验枚举类
 */
@Getter
public enum ExperienceEnum {
    STUDENT(0, "在校生"),
    ZERO(1, "0年"),
    ONE_TO_TWO(2, "1-2年"),
    THREE_TO_FIVE(3, "3-5年"),
    FIVE_TO_TEN(4, "5-10年"),
    TEN_PLUS(5, "10年+"),
    ;

    private Integer code;

    private String msg;

    ExperienceEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
