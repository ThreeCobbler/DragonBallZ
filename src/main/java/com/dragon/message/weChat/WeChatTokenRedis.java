package com.dragon.message.weChat;

import com.dragon.common.redis.AbstractRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ljn
 * @date 2019/4/3.
 */
@Component
public class WeChatTokenRedis extends AbstractRedis{

    private static final String WECHAT_TOKEN_KEY = "WeChatToken";


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected StringRedisTemplate getTemplate() {
        return redisTemplate;
    }

    public void saveToken(String token) {
        valueOps.set(WECHAT_TOKEN_KEY, token);
        getTemplate().expire(WECHAT_TOKEN_KEY, 30, TimeUnit.MINUTES);
    }

    public String getToken() {
        return valueOps.get(WECHAT_TOKEN_KEY);
    }

    public void deleteToken() {
        getTemplate().delete(WECHAT_TOKEN_KEY);
    }
}
