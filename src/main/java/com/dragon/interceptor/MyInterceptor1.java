package com.dragon.interceptor;

import com.alibaba.fastjson.JSON;
import com.dragon.common.dto.BaseResponse;
import com.dragon.common.utils.CookieUtils;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 339939 on 2018/3/26.
 */
public class MyInterceptor1 implements HandlerInterceptor {

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Autowired
    private IUserRedis userRedis;

    private List<String> ignoreList;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        String requestURI = request.getRequestURI();
        for (String url : ignoreList ) {
            if(url.equals(requestURI)) {
                return true;
            }
        }
        String cookieValue = CookieUtils.getCookieValue(request, TOKEN_KEY);
        UserEO userEO = userRedis.getUserEO(cookieValue);
        if (userEO == null) {
//            response.sendRedirect("登录地址?url="+request.getRequestURL());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setErrorMessage("请重新登陆");
            response.setHeader("Content-type","text/html; charset=UTF-8");
            response.getOutputStream().write(JSON.toJSONString(baseResponse).getBytes());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            return false;
        }
        // 只有返回true才会继续向下执行，返回false取消当前请求
        request.setAttribute("user",userEO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

    public List<String> getIgnoreList() {
        return ignoreList;
    }

    public void setIgnoreList(List<String> ignoreList) {
        this.ignoreList = ignoreList;
    }
}
