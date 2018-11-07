package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.CommentsApplicationTest;
import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.enums.CommentsTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommentsInfoServiceImplTest extends CommentsApplicationTest {

    @Autowired
    CommentsInfoServiceImpl service;

    @Test
    public void save() {
        CommentsInfo info = new CommentsInfo();
        info.setId("abc123");
        info.setType(CommentsTypeEnum.USER.getCode());
        info.setOwnerId("222222");
        info.setFromId("333333");
        info.setFromName("王五");
        info.setFromAvatar("http://345.png");
        info.setContent("这个小伙子不错");
        info.setLikeNum(3);
        CommentsInfo result = service.save(info);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOwnerId() {
        List<CommentsInfo> result = service.findByOwnerId("222222");
        Assert.assertNotEquals(0, result.size());
    }
}