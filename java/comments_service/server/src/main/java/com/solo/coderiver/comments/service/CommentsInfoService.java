package com.solo.coderiver.comments.service;

import com.solo.coderiver.comments.dataobject.CommentsInfo;

import java.util.List;

public interface CommentsInfoService {

    /**
     * 保存评论
     * @param info
     * @return
     */
    CommentsInfo save(CommentsInfo info);

    /**
     * 根据被评论者的id查询评论列表
     * @param ownerId
     * @return
     */
    List<CommentsInfo> findByOwnerId(String ownerId);
}
