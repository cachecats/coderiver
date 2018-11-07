package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dto.TalentsListDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class TalentsServiceImplTest extends UserApplicationTest {

    @Autowired
    TalentsServiceImpl service;

    @Test
    public void findAll() {
//        List<TalentsListDTO> all = service.findAll(0);
//        Assert.assertNotNull(all);
    }

    @Test
    public void findAllByRole() {
//        List<TalentsListDTO> dtos = service.findAllByRole(2, 0);
//        Assert.assertNotEquals(0, dtos.size());
    }

    @Test
    public void findAllByExperience() {
//        List<TalentsListDTO> dtos = service.findAllByExperience(3, 0);
//        Assert.assertNotEquals(0, dtos.size());
    }

    @Test
    public void findAllByRoleAndExperience() {
//        List<TalentsListDTO> dtos = service.findAllByRoleAndExperience(1, 3, 0);
//        Assert.assertNotEquals(0, dtos.size());
    }

}