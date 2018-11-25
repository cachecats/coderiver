package com.solo.coderiver.project.exception;

import com.solo.coderiver.project.enums.ResultEnums;
import lombok.Getter;

@Getter
public class ProjectException extends RuntimeException {

    private Integer code;

    private String msg;

    public ProjectException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProjectException(ResultEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }
}
