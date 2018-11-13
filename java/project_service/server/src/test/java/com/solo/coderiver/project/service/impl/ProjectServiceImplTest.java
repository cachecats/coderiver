package com.solo.coderiver.project.service.impl;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.VO.ProjectInfoVO;
import com.solo.coderiver.project.common.ProjectInfoOutput;
import com.solo.coderiver.project.dataobject.ProjectCategory;
import com.solo.coderiver.project.dataobject.ProjectInfo;
import com.solo.coderiver.project.dataobject.ProjectPicture;
import com.solo.coderiver.project.dataobject.UserProjectRelation;
import com.solo.coderiver.project.enums.RoleEnum;
import com.solo.coderiver.project.form.NewProjectForm;
import com.solo.coderiver.project.form.ProjectMemberForm;
import com.solo.coderiver.project.service.ProjectService;
import com.solo.coderiver.project.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ProjectServiceImplTest extends ProjectApplicationTests {

    @Autowired
    ProjectServiceImpl service;

    @Test
    public void findProjectByProjectId() {
        ProjectInfo info = service.findProjectByProjectId("1539259206662512790");
        Assert.assertNotNull(info);
    }

    @Test
    public void saveProject() {

        NewProjectForm form = new NewProjectForm();
        form.setProjectName("动物世界");
        form.setProjectAvatar("http://www.xxxxx.png");
        form.setProjectDifficulty(4.0f);
        form.setProjectIntroduce("见证奇妙的世界吧");
        form.setProjectStartDate("2018-9-30");
        form.setProjectEndDate("2018-12-21");
        form.setCategoryType(2);
        form.setCategoryName("社交");
        form.setOwnerRole(1);
        form.setUserId("222222");

        List<ProjectMemberForm> memberForms = new ArrayList<>();
        ProjectMemberForm pm1 = new ProjectMemberForm(1, 2);
        ProjectMemberForm pm2 = new ProjectMemberForm(2, 3);
        memberForms.add(pm1);
        memberForms.add(pm2);
        form.setMembers(memberForms);

        form.setProjectPictures("http://www.1.png,http://www.2.pn");
        service.saveProject(form);

    }

    @Test
    public void saveProjectCategory() {
        ProjectCategory category = new ProjectCategory(4, "餐饮");
        ProjectCategory result = service.saveProjectCategory(category);
        Assert.assertNotNull(result);
    }

    @Test
    public void findCategoryByCategoryType() {
        ProjectCategory category = service.findCategoryByCategoryType(4);
        Assert.assertNotNull(category);
    }


    @Test
    public void findRelationByProjectId() {
        List<UserProjectRelation> result = service.findRelationByProjectId("1539259206662512790");
        Assert.assertNotNull(result);
    }

    @Test
    public void findProjectsByUserId() {
        List<ProjectInfoOutput> list = service.findProjectsByUserId("222222");
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void getProjectList() {
        PageRequest page = PageRequest.of(0, 10);
//        List<ProjectInfoVO> list = service.getProjectList(page);
//        Assert.assertNotEquals(0, list.size());
    }

}