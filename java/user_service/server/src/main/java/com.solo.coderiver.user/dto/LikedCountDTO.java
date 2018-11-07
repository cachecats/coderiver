package com.solo.coderiver.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 点赞数量 DTO。用于存储从 Redis 取出来的被点赞数量
 */
@Data
public class LikedCountDTO implements Serializable {

    private static final long serialVersionUID = -2856160546081194945L;

    private String id;

    private Integer count;

    public LikedCountDTO() {
    }

    public LikedCountDTO(String id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
