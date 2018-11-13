package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.List;

@Slf4j
public class UserInfoRepositoryTest extends UserApplicationTest {

    @Autowired
    UserInfoRepository repository;

    @Test
    public void save() {
        UserInfo user = new UserInfo();
        user.setId("333333");
        user.setName("王五");
        user.setEmail("wu@163.com");
        user.setPassword("123456");
        user.setRole(2);
        user.setExperience(2);
        UserInfo info = repository.save(user);
        log.info(info.toString());
        Assert.assertNotNull(info);

    }

    @Test
    public void findUserInfoById() {
        UserInfo userInfo = repository.findUserInfoById("11111111");
        log.info(userInfo.toString());
        Assert.assertNotNull(userInfo);
    }

    @Test
    public void update() {
        UserInfo user = repository.findUserInfoById("11111111");
        user.setSex(1);
        user.setRole(3);
        user.setCity("北京");
        user.setInfluence(86);
        user.setWeekendStartTime(Time.valueOf("8:30:00"));
        user.setWeekendEndTime(Time.valueOf("22:30:00"));
        UserInfo result = repository.save(user);
        log.info(result.toString());
        Assert.assertNotNull(result);
    }

    @Test
    public void findByEmail() {
        UserInfo info = repository.findUserInfoByEmail("abc@163.com");
        log.info(info.toString());
        Assert.assertNotNull(info);
    }

    @Test
    public void findByRoleAndExperience() {
//        List<UserInfo> list = repository.findAllByRoleAndExperience(2, 2);
//        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByRole() {
//        List<UserInfo> list = repository.findAllByRole(2);
//        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByExperience() {
//        List<UserInfo> list = repository.findAllByExperience(3);
//        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findAll() {
//        List<UserInfo> all = repository.findAll();
//        Assert.assertNotEquals(0, all.size());
    }

}