package com.solo.coderiver.comments.service;

import com.solo.coderiver.comments.dto.CommentsInfoDTO;

import java.util.List;

public interface CommentsInfoService {

    /**
     * 保存评论
     *
     * @param info
     * @return
     */
    CommentsInfoDTO save(CommentsInfoDTO info);

    /**
     * 根据被评论的资源id查询评论列表
     *
     * @param ownerId
     * @return
     */
    List<CommentsInfoDTO> findByOwnerId(String ownerId);
}
