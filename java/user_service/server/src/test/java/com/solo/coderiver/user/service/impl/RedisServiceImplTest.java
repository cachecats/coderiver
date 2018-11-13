package com.solo.coderiver.user.service.impl;

import com.solo.coderiver.user.UserApplicationTest;
import com.solo.coderiver.user.dataobject.UserLike;
import com.solo.coderiver.user.utils.RedisKeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
public class RedisServiceImplTest extends UserApplicationTest {

    @Autowired
    RedisServiceImpl service;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void saveLiked2Redis() {
        service.saveLiked2Redis("222222", "333333");
        Integer value = (Integer) redisTemplate.opsForHash().get(RedisKeyUtils.MAP_KEY_USER_LIKED,
                RedisKeyUtils.getLikedKey("222222", "333333"));
        Assert.assertTrue(1 == value);
    }

    @Test
    public void unlikeFromRedis() {
        service.unlikeFromRedis("222222", "333333");
        Integer value = (Integer) redisTemplate.opsForHash().get(RedisKeyUtils.MAP_KEY_USER_LIKED,
                RedisKeyUtils.getLikedKey("222222", "333333"));
        Assert.assertTrue(0 == value);
    }

    @Test
    public void deleteLikedFromRedis() {
        service.deleteLikedFromRedis("222222", "333333");
        Integer value = (Integer) redisTemplate.opsForHash().get(RedisKeyUtils.MAP_KEY_USER_LIKED,
                RedisKeyUtils.getLikedKey("222222", "333333"));
        Assert.assertTrue(1 != value);
    }

    @Test
    public void incrementLikedCount() {
        service.incrementLikedCount("222222");
    }

    @Test
    public void decrementLikedCount() {
        service.decrementLikedCount("222222");
    }

    @Test
    public void getLikedFromRedis() {
        List<UserLike> list = service.getLikedDataFromRedis();
        log.info(list.toString());
    }
}