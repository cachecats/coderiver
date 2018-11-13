package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.dto.UserInfoDTO;
import com.solo.coderiver.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class UserServiceImplTest extends UserApplicationTest {

    @Autowired
    UserServiceImpl service;

    @Test
    public void registerByEmail() {
        UserInfoDTO user = new UserInfoDTO();
        user.setId("11111111");
        user.setName("张三");
        user.setEmail("abc@163.com");
        user.setPassword("123456");
        user.setRole(1);
        user.setExperience(3);
        UserInfoDTO dto = service.registerByEmail(user);
        log.info(dto.toString());
        Assert.assertNotNull(dto);
    }

    @Test
    public void updateInfo() {
    }

    @Test
    public void loginByEmail() {
        UserInfoDTO dto = service.loginByEmail("abc@163.com", "123456");
        Assert.assertNotNull(dto);
    }

    @Test
    public void resetPassword() {
        UserInfo userInfo = service.resetPassword("1538968406255385201", "123456", "123");
        Assert.assertNotNull(userInfo);
    }

    @Test
    public void loginByTel() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
//        List<UserInfo> all = service.findAll();
//        Assert.assertNotEquals(0, all.size());
    }

}