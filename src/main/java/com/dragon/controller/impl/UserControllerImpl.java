package com.dragon.controller.impl;

import com.dragon.controller.IUserController;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public UserEO findById(@RequestParam Long id){
        return userService.findById(id);
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestBody UserEO user){
        userService.updateUser(user);
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.GET)
    public void deleteById(@RequestParam Long id){
        userService.deleteById(id);
    }


}
