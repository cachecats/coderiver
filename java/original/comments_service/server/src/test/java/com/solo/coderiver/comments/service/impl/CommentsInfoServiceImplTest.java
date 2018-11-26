package com.solo.coderiver.comments.service.impl;

import com.solo.coderiver.comments.CommentsApplicationTest;
import com.solo.coderiver.comments.dataobject.CommentsInfo;
import com.solo.coderiver.comments.dto.CommentsInfoDTO;
import com.solo.coderiver.comments.enums.CommentsTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentsInfoServiceImplTest extends CommentsApplicationTest {

    @Autowired
    CommentsInfoServiceImpl service;

    @Test
    public void save() {
        CommentsInfoDTO info = new CommentsInfoDTO();
        info.setId("abc123");
        info.setType(CommentsTypeEnum.USER.getCode());
        info.setOwnerId("1541062468073593543");
        info.setFromId("333333");
        info.setFromName("王五");
        info.setContent("这个小伙子不错");
        info.setLikeNum(3);

        CommentsInfoDTO info1 = new CommentsInfoDTO();
        info1.setPid("abc123");
        info1.setId("abc456");
        info1.setType(CommentsTypeEnum.USER.getCode());
        info1.setOwnerId("1541062468073593543");
        info1.setFromId("222222");
        info1.setFromName("李四");
        info1.setContent("这个小伙子不错啊啊啊啊啊");
        info1.setLikeNum(2);
        CommentsInfoDTO result = service.save(info1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOwnerId() {
        List<CommentsInfoDTO> result = service.findByOwnerId("1541062468073593543");
        Assert.assertNotEquals(0, result.size());
    }
}