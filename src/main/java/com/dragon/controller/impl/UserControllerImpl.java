package com.dragon.controller.impl;

import com.dragon.controller.IUserController;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 339939 on 2018/3/22.
 */
@RestController
@RequestMapping("user")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void add(@RequestBody UserEO user){
        userService.add(user);
    }


}
