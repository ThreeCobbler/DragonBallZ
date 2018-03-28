package com.dragon.service;

import com.dragon.dao.entity.UserEO;

import java.text.ParseException;
import java.util.List;

/**
 * Created by 339939 on 2018/3/22.
 */
public interface IUserService {

    UserEO add(UserEO user);

    UserEO findById(Long id);

    UserEO updateUser(UserEO user);

    void deleteById(Long id);

    boolean checkUser(String userAccount, String userName);

    List<UserEO> getUserList(int page,int size,String startTime,String endTime) throws ParseException;

}
