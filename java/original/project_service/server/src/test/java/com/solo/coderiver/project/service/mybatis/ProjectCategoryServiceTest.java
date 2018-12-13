package com.solo.coderiver.project.service.mybatis;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: solo
 * @Date: 2018/12/12 2:50 PM
 * @Version 1.0
 */
public class ProjectCategoryServiceTest extends ProjectApplicationTests {

    @Autowired
    ProjectCategoryService service;

    @Test
    public void insert() {
        ProjectCategory category = new ProjectCategory();
        category.setCategoryType(11);
        category.setCategoryName("媒体");
        int result = service.insert(category);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByType(){
        int result = service.deleteByType(10);
        Assert.assertEquals(1, result);
    }

    @Test
    public void update(){
        ProjectCategory category = new ProjectCategory();
        category.setCategoryType(11);
        category.setCategoryName("职场");
        int result = service.update(category);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByType(){
        ProjectCategory result = service.findByType(11);
        Assert.assertNotNull(result);
    }
}