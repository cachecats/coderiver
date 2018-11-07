package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.dataobject.CommentsReply;
import com.solo.coderiver.comments.repository.CommentsReplyRepository;
import com.solo.coderiver.comments.service.CommentsReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsReplyServiceImpl implements CommentsReplyService {

    @Autowired
    CommentsReplyRepository repository;

    @Override
    public CommentsReply save(CommentsReply reply) {
        return repository.save(reply);
    }

    @Override
    public List<CommentsReply> findByCommentId(String commentId) {
        return repository.findByCommentId(commentId);
    }
}
