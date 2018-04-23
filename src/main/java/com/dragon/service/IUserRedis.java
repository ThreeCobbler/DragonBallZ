package com.dragon.service;

import com.dragon.dao.entity.UserEO;

/**
 * Created by ljn on 2018/4/18.
 */
public interface IUserRedis {

    void addToken(String uuid,UserEO userEO);

    UserEO getUserEO(String token);

    void delete(String token);
}
