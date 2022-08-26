package com.services.core.util;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

/**
 * redis工具
 */
@Component
public class RedisUtil
{
    public final StringRedisTemplate stringRedisTemplate;

    public final ValueOperations<String,Object> valueOperations;

    public final HashOperations<String, String, Object> hashOperations;

    public final ListOperations<String, Object> listOperations;

    public final SetOperations<String, Object> setOperations;

    public final ZSetOperations<String, Object> zSetOperations;

    public RedisUtil(StringRedisTemplate stringRedisTemplate, ValueOperations<String, Object> valueOperations,
                     HashOperations<String, String, Object> hashOperations,
                     ListOperations<String, Object> listOperations, SetOperations<String, Object> setOperations,
                     ZSetOperations<String, Object> zSetOperations)
    {
        this.stringRedisTemplate = stringRedisTemplate;
        this.valueOperations = valueOperations;
        this.hashOperations = hashOperations;
        this.listOperations = listOperations;
        this.setOperations = setOperations;
        this.zSetOperations = zSetOperations;
    }
}
