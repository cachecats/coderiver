package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.UserLike;
import com.solo.coderiver.user.enums.LikedStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class LikedServiceImplTest extends UserApplicationTest {

    @Autowired
    LikedServiceImpl service;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void save() {
        UserLike like = new UserLike();
        like.setLikedUserId("222222");
        like.setLikedPostId("333333");
        like.setStatus(LikedStatusEnum.LIKE.getCode());
        UserLike save = service.save(like);
        Assert.assertNotNull(save);
    }

    @Test
    public void getLikedListByLikedUserId() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<UserLike> page = service.getLikedListByLikedUserId("222222", pageRequest);
        Assert.assertNotEquals(0, page.getTotalElements());

    }

    @Test
    public void getLikedListByLikedPostId() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<UserLike> page = service.getLikedListByLikedPostId("333333", pageRequest);
        Assert.assertNotEquals(0, page.getTotalElements());
    }

    @Test
    public void getByLikedUserIdAndLikedPostId() {
        UserLike userLike = service.getByLikedUserIdAndLikedPostId("222222", "333333");
        Assert.assertNotNull(userLike);
    }

    @Test
    public void redisTest() {
//        Map<String, String> maps = new HashMap<>();
//        maps.put("222222:444444", "444444");
//        maps.put("333333:444444", "444444");
//        maps.put("333333:555555", "555555");
//        redisTemplate.opsForHash().putAll("user-liked", maps);
        Long increment = redisTemplate.opsForHash().increment("user-liked-count", "222222", 1);
    }

    @Test
    public void redisGetTest() {
        Integer num = (Integer) redisTemplate.opsForHash().get("user-liked-count", "222222");
        log.info("num: {}", num);
    }

    @Test
    public void redisDeleteTest() {
        redisTemplate.opsForHash().delete("user-liked", "333333");
    }

    @Test
    public void redisDecTest() {
        redisTemplate.opsForHash().increment("user-liked-count", "222222", -1);
    }

    @Test
    public void transformFromRedis2Database() {
        service.transLikedFromRedis2DB();
    }

    @Test
    public void transLikedCountFromRedis2DB() {
        service.transLikedCountFromRedis2DB();
    }
}