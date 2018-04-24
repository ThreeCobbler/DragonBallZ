package com.dragon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dragon.common.redis.AbstractRedis;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by 339939 on 2018/4/18.
 */
@Component
public class UserRedisImpl extends AbstractRedis implements IUserRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected StringRedisTemplate getTemplate() {
        return redisTemplate;
    }

    private final static String prefix = "USER_SESSION:";

    @Override
    public void addToken(String uuid, UserEO userEO) {
        valueOps.set(prefix + uuid, JSON.toJSONString(userEO),18000, TimeUnit.SECONDS);
    }

    @Override
    public UserEO getUserEO(String token) {
        String json = valueOps.get(prefix + token);
        UserEO userEO = JSONObject.parseObject(json, UserEO.class);
        return userEO;
    }

    @Override
    public void delete(String token) {
        redisTemplate.delete(prefix + token);
    }
}
