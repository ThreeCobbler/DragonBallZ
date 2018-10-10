package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
import com.dragon.common.utils.CookieUtils;
import com.dragon.controller.IUserController;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserRedis;
import com.dragon.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 339939 on 2018/3/22.
 */
@RestController
@RequestMapping("user")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRedis userRedis;

    @Value(value="${TOKEN_KEY}")
    private String TOKEN_KEY;

    /**
     * 注册
     * @param user
     * @return
     * 等价于 PostMapping
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
     * 等价于 GetMapping
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

    /**
     * 登陆
     * @param userAccount
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public BaseResponse login(@RequestParam String userAccount, @RequestParam String userPassword,
                              HttpServletRequest request,HttpServletResponse httpResponse) {
        BaseResponse response = new BaseResponse();
        try{
            String uid = userService.login(userAccount, userPassword);
            CookieUtils.setCookie(request,httpResponse,TOKEN_KEY,uid);
            response.setMessage("登陆成功");
            response.setResult(uid);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    @RequestMapping(value="getUserByToken",method = RequestMethod.GET)
    public BaseResponse getUserByToken(@RequestParam String token) {
        BaseResponse response = new BaseResponse();
        try{
            UserEO userEO = userRedis.getUserEO(token);
            if (userEO == null) {
                throw new RuntimeException("请重新登陆");
            }
            userRedis.addToken(token,userEO);
            response.setResult(userEO);
        }catch (RuntimeException e){
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public BaseResponse logout(HttpServletRequest request,HttpServletResponse httpServletResponse) {
        BaseResponse response = new BaseResponse();
        try{
            String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
            CookieUtils.deleteCookie(request,httpServletResponse,TOKEN_KEY);
            userRedis.delete(token);
        }catch (Exception e) {
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }


}
