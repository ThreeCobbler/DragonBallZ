package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
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
    public BaseResponse add(@RequestBody UserEO user){
        BaseResponse response = new BaseResponse();
        try{
            userService.add(user);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public BaseResponse findById(@RequestParam Long id){
        BaseResponse response = new BaseResponse();
        try{
            UserEO user = userService.findById(id);
            response.setResult(user);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public BaseResponse updateUser(@RequestBody UserEO user){
        BaseResponse response = new BaseResponse();
        try{
            userService.updateUser(user);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.GET)
    public BaseResponse deleteById(@RequestParam Long id){
        BaseResponse response = new BaseResponse();
        try{
            userService.deleteById(id);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "checkUser",method = RequestMethod.GET)
    public BaseResponse checkUser(@RequestParam String userAccount,@RequestParam String userName){
        BaseResponse response = new BaseResponse();
        try{
            userService.checkUser(userAccount,userName);
        }catch (RuntimeException e) {
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }


}
