package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.EducationExperience;
import com.solo.coderiver.user.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EducationServiceImplTest extends UserApplicationTest {

    @Autowired
    EducationServiceImpl service;

    @Test
    public void findByUserId() {
        List<EducationExperience> list = service.findByUserId("222222");
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void save() throws Exception {
        EducationExperience experience = new EducationExperience();
        experience.setUserId("222222");
        experience.setSchoolName("南开");
        experience.setMajor("软件工程");
        experience.setDegree("本科");
        experience.setComment("技能大赛第一名");
        Date startDate = DateUtils.dateParse("2010-09-20", "yyyy-MM-dd");
        experience.setStartDate(startDate);
        Date endDate = DateUtils.dateParse("2014-6-10", "yyyy-MM-dd");
        experience.setEndDate(endDate);

        EducationExperience result = service.save(experience);
        Assert.assertNotNull(result);
    }
}