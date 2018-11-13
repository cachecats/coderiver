package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.UserTeamRelation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserTeamRepositoryTest extends UserApplicationTest {

    @Autowired
    UserTeamRepository repository;

    @Test
    public void save() {
        UserTeamRelation relation = new UserTeamRelation("222222", "1539241759133234444");
        UserTeamRelation save = repository.save(relation);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByUserId() {
        List<UserTeamRelation> list = repository.findByUserId("222222");
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByTeamId() {
        List<UserTeamRelation> list = repository.findByTeamId("1539242325688256752");
        Assert.assertNotEquals(0, list.size());
    }
}