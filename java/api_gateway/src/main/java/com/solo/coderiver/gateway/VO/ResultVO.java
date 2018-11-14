package com.solo.coderiver.gateway.VO;

import lombok.Data;

@Data
public class ResultVO<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public ResultVO() {
    }
}
