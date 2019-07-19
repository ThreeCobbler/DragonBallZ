package com.dragon.service;

import com.dragon.dao.entity.OrderEO;
import com.dragon.dao.entity.UserEO;

import java.util.List;
import java.util.Set;

/**
 * Created by ljn on 2018/4/18.
 */
public interface IUserRedis {

    void addToken(String uuid,UserEO userEO);

    UserEO getUserEO(String token);

    void delete(String token);

    void pushOrderId(String orderId);

    String getLastOrderId();

    List<String> getOrderIdList();

    void pushOrder(String orderId);

    String getListOrder();

    List<String> getOrderList();

    void saveOrderIdBySet(String orderId);

    String getOrderIdBySet();

    Set<String> getOrderSet();

    void setHashOrderId(String orderId);

    String getHashOrderId();

    void saveOrderIdForZSet(OrderEO order, long score);

    List getOrderIdForZSet();

    void setValue(String key, String value);
}
