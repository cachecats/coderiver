package com.solo.coderiver.comments.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CommentsInfoForm {

    //评论类型。1用户评论，2项目评论，3资源评论
    @NotNull(message = "评论类型不能为空")
    @ApiModelProperty("评论类型。1用户评论，2项目评论，3资源评论")
    private Integer type;

    //被评论者的id
    @NotEmpty(message = "被评论者id不能为空")
    @ApiModelProperty("被评论者的id")
    private String ownerId;

    //评论者id
    @NotEmpty(message = "评论者id不能为空")
    @ApiModelProperty("评论者的id")
    private String fromId;

    //评论者名字
    @NotEmpty(message = "评论者名字不能为空")
    @ApiModelProperty("评论者名字")
    private String fromName;

    //评论者头像
    @ApiModelProperty("评论者头像，可为空")
    private String fromAvatar;

    //获得点赞的数量
    @ApiModelProperty("获得点赞的数量。可为空")
    private Integer likeNum = 0;

    //评论内容
    @NotEmpty(message = "评论内容不能为空")
    @ApiModelProperty("评论内容")
    private String content;

}
