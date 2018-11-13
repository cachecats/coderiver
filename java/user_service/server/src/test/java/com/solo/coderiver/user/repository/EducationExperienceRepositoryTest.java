package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.EducationExperience;
import com.solo.coderiver.user.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class EducationExperienceRepositoryTest extends UserApplicationTest {

    @Autowired
    EducationExperienceRepository repository;

    @Test
    public void save() throws Exception {
        EducationExperience experience = new EducationExperience();
        experience.setId(3);
        experience.setUserId("11111111");
        experience.setSchoolName("清华");
        experience.setMajor("计算机科学与技术");
        experience.setDegree("硕士");
        experience.setComment("获得二等奖学金");

        Date startDate = DateUtils.dateParse("2010-09-20", "yyyy-MM-dd");
        experience.setStartDate(startDate);

        Date endDate = DateUtils.dateParse("2014-6-10", "yyyy-MM-dd");
        experience.setEndDate(endDate);
        EducationExperience result = repository.save(experience);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserId() {
        List<EducationExperience> list = repository.findByUserId("222222");
        Assert.assertNotEquals(0, list.size());
    }


}