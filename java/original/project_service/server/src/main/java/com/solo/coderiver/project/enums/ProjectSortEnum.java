package com.solo.coderiver.project.enums;

import lombok.Getter;

@Getter
public enum ProjectSortEnum {
    DEFAULT(1, "默认排序"),
    DIFFICULTY_LOW_TO_HIGH(2, "按项目难度从低到高排序"),
    DIFFICULTY_HIGH_TO_LOW(3, "按项目难度从高到低排序"),
    ;

    private Integer code;

    private String msg;

    ProjectSortEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
