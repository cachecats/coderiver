package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.ProjectCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProjectCategoryRepositoryTest extends ProjectApplicationTests {

    @Autowired
    ProjectCategoryRepository repository;

    @Test
    public void save() {
        ProjectCategory category = new ProjectCategory();
        category.setCategoryName("电商");
        category.setCategoryType(1);
        ProjectCategory save = repository.save(category);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByCategoryType() {
        ProjectCategory result = repository.findByCategoryType(1);
        Assert.assertNotNull(result);
    }
}