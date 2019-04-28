package com.dragon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dragon.common.redis.AbstractRedis;
import com.dragon.dao.entity.OrderEO;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    /**
     * value
     * @param orderId
     */
    @Override
    public void pushOrderId(String orderId) {
        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps("DragonBall:OrderId");
        listOperations.leftPush(orderId);
    }

    @Override
    public String getLastOrderId() {
        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps("DragonBall:OrderId");
        return listOperations.rightPop();
    }

    /**
     * list
     * @return
     */
    @Override
    public List<String> getOrderIdList() {
        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps("DragonBall:OrderId");
        List<String> list = listOperations.range(0, -1);
        return list;
    }

    @Override
    public void pushOrder(String orderId) {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("DragonBall:Test", orderId);
    }

    @Override
    public String getListOrder() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        return listOperations.rightPop("DragonBall:Test");
    }

    @Override
    public List<String> getOrderList() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        return listOperations.range("DragonBall:Test", 0, -1);
    }

    /**
     * Set
     * @return
     */
    @Override
    public void saveOrderIdBySet(String orderId) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        Long add = setOperations.add("DragonBall:Set", orderId);
        System.out.println(add);
    }

    @Override
    public String getOrderIdBySet() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String pop = setOperations.pop("DragonBall:Set");
        List<String> list = setOperations.pop("DragonBall:Set", 5);
        return pop;
    }

    @Override
    public Set<String> getOrderSet() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        return setOperations.members("DragonBall:Set");
    }

    /**
     * Hash
     * @param orderId
     */
    @Override
    public void setHashOrderId(String orderId) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("DragonBall:Hash", 1L+"", orderId);
        BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps("DragonBall:Hash");
        boundHashOps.put("2", orderId);
    }

    @Override
    public String getHashOrderId() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String order = hashOperations.get("DragonBall:Hash", "1");
        BoundHashOperations<String, String, String> boundHashOps = redisTemplate.boundHashOps("DragonBall:Hash");
        String orderId = boundHashOps.get("2");
        return orderId;
    }

    /**
     * zSet
     * @param order
     * @param score
     */
    @Override
    public void saveOrderIdForZSet(OrderEO order, long score) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        String json = JSONObject.toJSONString(order);
        zSetOperations.add("DragonBall:zSet", json, score);
    }

    @Override
    public List getOrderIdForZSet() {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Set<String> set = zSetOperations.range("DragonBall:zSet", 0, -1);
        if (CollectionUtils.isEmpty(set)) {
            return null;
        }
        List<OrderEO> list = new ArrayList<>();
        for (String str : set) {
            OrderEO orderEO = JSON.parseObject(str, OrderEO.class);
            list.add(orderEO);
        }
        return list;
    }
}
