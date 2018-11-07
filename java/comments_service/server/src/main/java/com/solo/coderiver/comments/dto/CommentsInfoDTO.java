package com.solo.coderiver.comments.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommentsInfoDTO implements Serializable {

    private static final long serialVersionUID = -6788130126931979110L;

    //评论主键id
    private String id;

    //评论类型。1用户评论，2项目评论，3资源评论
    private Integer type;

    //被评论者的id
    private String ownerId;

    //评论者id
    private String fromId;

    //评论者名字
    private String fromName;

    //评论者头像
    private String fromAvatar;

    //获得点赞的数量
    private Integer likeNum;

    //评论内容
    private String content;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
