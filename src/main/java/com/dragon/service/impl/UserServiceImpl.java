package com.dragon.service.impl;

import com.dragon.dao.entity.UserEO;
import com.dragon.dao.mapper.UserEOMapper;
import com.dragon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 339939 on 2018/3/22.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserEOMapper userEOMapper;

    @Override
    public void add(UserEO user) {
        userEOMapper.insert(user);
    }
}
