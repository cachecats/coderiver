package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.WorkExperience;
import com.solo.coderiver.user.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class WorkServiceImplTest extends UserApplicationTest {

    @Autowired
    WorkServiceImpl service;

    @Test
    public void findByUserId() {
        List<WorkExperience> list = service.findByUserId("222222");
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void save() throws Exception {
        WorkExperience work = new WorkExperience();
        work.setUserId("111111");
        work.setPosition("前端工程师");
        work.setComment("负责公司前端项目的开发维护");
        work.setCompanyName("腾通讯");
        Date startDate = DateUtils.dateParse("2017-1-11");
        Date endDate = DateUtils.dateParse("2018-8-16");
        work.setStartDate(startDate);
        work.setEndDate(endDate);
        WorkExperience result = service.save(work);
        Assert.assertNotNull(result);
    }
}