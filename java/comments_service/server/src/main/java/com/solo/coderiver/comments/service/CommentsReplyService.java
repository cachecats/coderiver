package com.solo.coderiver.comments.service;

import com.solo.coderiver.comments.dataobject.CommentsReply;

import java.util.List;

public interface CommentsReplyService {

    /**
     * 保存评论回复
     * @param reply
     * @return
     */
    CommentsReply save(CommentsReply reply);

    /**
     * 根据评论id查询回复
     * @param commentId
     * @return
     */
    List<CommentsReply> findByCommentId(String commentId);
}
