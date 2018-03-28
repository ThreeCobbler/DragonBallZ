package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
import com.dragon.controller.IUserController;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 339939 on 2018/3/22.
 */
@RestController
@RequestMapping("user")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponse add(@RequestBody UserEO user){
        BaseResponse response = new BaseResponse();
        try{
            if (StringUtils.isBlank(user.getUserAccount())) {
                throw new RuntimeException("帐号不能为空");
            }
            if (StringUtils.isBlank(user.getUserName())) {
                throw new RuntimeException("用户名不能为空");
            }
            if (StringUtils.isBlank(user.getUserPassword())) {
                throw new RuntimeException("密码不能为空");
            }
            userService.add(user);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 查找
     * @param id
     * @return
     */
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

    /**
     *
     * @param user
     * @return
     */
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

    /**
     * 修改
     * @param id
     * @return
     */
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

    /**
     * 校验
     * @param userAccount
     * @param userName
     * @return
     */
    @RequestMapping(value = "checkUser",method = RequestMethod.GET)
    public BaseResponse checkUser(@RequestParam(value = "userAccount",required = false) String userAccount,
                                  @RequestParam(value = "userName",required = false) String userName){
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

    @RequestMapping(value = "getUserList",method = RequestMethod.GET)
    public BaseResponse getUserList(@RequestParam Integer page,@RequestParam Integer size,
                                    @RequestParam(value = "startTime",required = false) String startTime,
                                    @RequestParam(value = "endTime",required = false) String endTime) {
        BaseResponse response = new BaseResponse();
        try{
            List<UserEO> userList = userService.getUserList(page, size,startTime,endTime);
            PageInfo pages = new PageInfo(userList);
            response.setData(userList);
            response.setPageIndex(page);
            response.setPageSize(size);
            response.setTotalCount(pages.getTotal());
        }catch (RuntimeException e) {
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }


}
