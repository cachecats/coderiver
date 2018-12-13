package com.solo.coderiver.project.service.mybatis;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectMember;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: solo
 * @Date: 2018/12/13 10:39 AM
 * @Version 1.0
 */
public class ProjectMemberServiceMyBatisImplTest extends ProjectApplicationTests {

    @Autowired
    ProjectMemberServiceMyBatisImpl service;

    @Test
    public void findByProjectId() {
        List<ProjectMember> list = service.findByProjectId("1541062468073593543");
        Assert.assertNotEquals(0, list.size());
    }
}