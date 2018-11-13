package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.utils.KeyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProjectInfoRepositoryTest extends ProjectApplicationTests {

    @Autowired
    ProjectInfoRepository repository;

    @Test
    public void save() {
        ProjectInfo info = new ProjectInfo();
        info.setProjectId(KeyUtils.genUniqueKey());
        info.setProjectName("出埃及记");
        info.setCategoryType(1);
        info.setCategoryName("电商");
        info.setProjectAvatar("http://xxxxx.png");
        info.setProjectDifficulty(3.5f);
        info.setProjectIntroduce("啊啊啊，出埃及了");
        info.setProjectProgress(2);
        info.setProjectCreatorId("222222");
        ProjectInfo save = repository.save(info);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByProjectId() {
        ProjectInfo info = repository.findByProjectId("1539259206662512790");
        Assert.assertNotNull(info);
    }
}