package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.CommentsApplicationTest;
import com.solo.coderiver.comments.dataobject.CommentsReply;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommentsReplyServiceImplTest extends CommentsApplicationTest {

    @Autowired
    CommentsReplyServiceImpl service;

    @Test
    public void save() {
        CommentsReply reply = new CommentsReply();
        reply.setCommentId("abc123");
        reply.setFromId("444444");
        reply.setFromName("衡器");
        reply.setFromAvatar("http://we.png");
        reply.setToId("333333");
        reply.setToName("王五");
        reply.setToAvatar("http://ov.png");
        reply.setContent("评价很中肯");
        CommentsReply result = service.save(reply);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCommentId() {
        List<CommentsReply> result = service.findByCommentId("abc123");
        Assert.assertNotEquals(0, result.size());
    }
}