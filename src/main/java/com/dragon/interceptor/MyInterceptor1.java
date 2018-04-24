package com.dragon.interceptor;

import com.dragon.common.utils.CookieUtils;
import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserRedis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 339939 on 2018/3/26.
 */
public class MyInterceptor1 implements HandlerInterceptor {

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Autowired
    private IUserRedis userRedis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        String requestURI = request.getRequestURI();
        String cookieValue = CookieUtils.getCookieValue(request, TOKEN_KEY);
        if (StringUtils.isBlank(cookieValue)) {
//            response.sendRedirect("登录地址?url="+request.getRequestURL());
            //将当前url传到登录页面，登录成功后跳转回来
//            throw new RuntimeException("请重新登");
            return false;
        }
        UserEO userEO = userRedis.getUserEO(cookieValue);
        if (userEO == null) {
//            response.sendRedirect("登录地址?url="+request.getRequestURL());
            return false;
        }
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
