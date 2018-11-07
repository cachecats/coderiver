package com.solo.coderiver.comments.repository;

import com.solo.coderiver.comments.dataobject.CommentsReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsReplyRepository extends JpaRepository<CommentsReply, Integer> {

    List<CommentsReply> findByCommentId(String commentId);
}
