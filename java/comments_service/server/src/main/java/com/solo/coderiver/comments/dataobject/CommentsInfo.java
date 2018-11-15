package com.solo.coderiver.comments.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 评论表主表
 */
@Entity
@Data
@DynamicUpdate
public class CommentsInfo implements Serializable{

    private static final long serialVersionUID = -4568928073579442976L;

    //评论主键id
    @Id
    private String id;

    //该条评论的父评论id
    private String pid;

    //评论的资源id。标记这条评论是属于哪个资源的。资源可以是人、项目、设计资源
    private String ownerId;

    //评论类型。1用户评论，2项目评论，3资源评论
    private Integer type;

    //评论者id
    private String fromId;

    //评论者名字
    private String fromName;

    //被评论者id
    private String toId;

    //被评论者名字
    private String toName;

    //获得点赞的数量
    private Integer likeNum;

    //评论内容
    private String content;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
