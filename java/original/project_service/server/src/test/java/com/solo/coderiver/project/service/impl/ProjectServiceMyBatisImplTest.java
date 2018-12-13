package com.solo.coderiver.project.service.impl;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.service.mybatis.ProjectServiceMyBatisImpl;
import com.solo.coderiver.project.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: solo
 * @Date: 2018/12/7 3:34 PM
 * @Version 1.0
 */
@Slf4j
public class ProjectServiceMyBatisImplTest extends ProjectApplicationTests {

    @Autowired
    ProjectServiceMyBatisImpl service;

    @Test
    public void findProjectByProjectId() {
        ProjectInfo result = service.findProjectByProjectId("1541044293647796709");
        log.info("result: {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void insert(){
        ProjectInfo info = new ProjectInfo();
        info.setProjectId(KeyUtils.genUniqueKey());
        info.setProjectName("出埃及记3");
        info.setCategoryType(2);
        info.setCategoryName("电商");
        info.setProjectAvatar("http://xxxxx.png");
        info.setProjectDifficulty(4.0F);
        info.setProjectIntroduce("啊啊啊，出埃及了hahah");
        info.setProjectProgress(2);
        info.setProjectCreatorId("222222");

        Integer result = service.insertProject(info);
        Assert.assertEquals(Integer.valueOf(1), result);
        log.info("insert: {}", result);
    }

    @Test
    public void update(){
        Integer result = service.updateProjectName("1544500274289532209", "复仇者联盟");
        Assert.assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void delete(){
        Integer result = service.deleteProject("1544179847268973275");
        Assert.assertEquals(Integer.valueOf(1), result);
    }
}