package com.solo.coderiver.user.utils;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 操作 Redis 的工具类
 */
@Component
public class RedisUtils {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, String value, Long expired, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().set(key, value, expired, timeUnit);
    }
}
