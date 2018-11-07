package com.solo.coderiver.comments.exception;

import com.solo.coderiver.comments.enums.ResultEnums;
import lombok.Getter;

@Getter
public class CommentsException extends RuntimeException {

    private Integer code;

    private String msg;

    public CommentsException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public CommentsException(ResultEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }
}
