package com.solo.coderiver.comments.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class CommentsReplyForm implements Serializable {

    private static final long serialVersionUID = 761952653102752686L;

    //评论主表id
    @NotEmpty(message = "评论主表id不能为空")
    @ApiModelProperty(value = "评论主表id", required = true)
    private String commentId;

    //评论者id
    @ApiModelProperty(value = "评论者id", required = true)
    @NotEmpty(message = "评论者id不能为空")
    private String fromId;

    //评论者名字
    @ApiModelProperty(value = "评论者名字", required = true)
    @NotEmpty(message = "评论者名字不能为空")
    private String fromName;

    //评论者头像
    @ApiModelProperty("评论者头像")
    private String fromAvatar;

    //被评论者id
    @ApiModelProperty(value = "被评论者id", required = true)
    @NotEmpty(message = "被评论者id不能为空")
    private String toId;

    //被评论者名字
    @ApiModelProperty(value = "被评论者名字", required = true)
    @NotEmpty(message = "被评论者名字不能为空")
    private String toName;

    //被评论者头像
    @ApiModelProperty("被评论者头像")
    private String toAvatar;

    //评论内容
    @ApiModelProperty(value = "评论内容", required = true)
    @NotEmpty(message = "评论内容不能为空")
    private String content;

}
