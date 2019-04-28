package com.dragon.common.redis;

import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;

/**
 * Created by ljn on 2018/4/18.
 */
public abstract class AbstractRedis {

    protected ValueOperations<String,String> valueOps;

    protected SetOperations<String,String> setOperations;

    protected ZSetOperations<String,String> zSetOperations;

    protected ListOperations<String,String> listOperations;

    protected HashOperations<String, String, String> hashOperations;

    public AbstractRedis() {
    }

    @PostConstruct
    private void afterInitialization(){
        this.valueOps = getTemplate().opsForValue();
        this.setOperations = getTemplate().opsForSet();
        this.zSetOperations = getTemplate().opsForZSet();
        this.listOperations = getTemplate().opsForList();
        this.hashOperations = getTemplate().opsForHash();
    }

    /**
     * @return the template
     */
    protected abstract StringRedisTemplate getTemplate();
}
