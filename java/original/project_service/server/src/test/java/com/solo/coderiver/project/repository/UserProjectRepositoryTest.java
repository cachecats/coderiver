package com.solo.coderiver.project.repository;

import com.solo.coderiver.project.ProjectApplicationTests;
import com.solo.coderiver.project.dataobject.UserProjectRelation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserProjectRepositoryTest extends ProjectApplicationTests {

    @Autowired
    UserProjectRepository repository;

    @Test
    public void save() {
        UserProjectRelation relation = new UserProjectRelation("222222", "1539259206662512790");
        UserProjectRelation save = repository.save(relation);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByProjectId() {
        List<UserProjectRelation> result = repository.findByProjectId("1539259206662512790");
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserId() {
        List<UserProjectRelation> result = repository.findByUserId("222222");
        Assert.assertNotNull(result);
    }
}