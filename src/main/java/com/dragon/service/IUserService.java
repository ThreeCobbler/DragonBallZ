package com.dragon.service;

import com.dragon.dao.entity.UserEO;

/**
 * Created by 339939 on 2018/3/22.
 */
public interface IUserService {

    UserEO add(UserEO user);

    UserEO findById(Long id);

    UserEO updateUser(UserEO user);

    void deleteById(Long id);

}
