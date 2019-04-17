package com.dragon.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/5/7.
 */
@Component
public class MyInterceptor2 implements HandlerInterceptor {

    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(">>>MyInterceptor2>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        StringBuffer requestURL = request.getRequestURL();
        //拿到uri与baseUri的映射关系
        String servletUri = urlPathHelper.getServletPath(request);
        String method = request.getMethod();
        StringBuffer sb = new StringBuffer();
        if("POST".equals(method)) {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
        }else {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    sb.append(entry.getKey());
                }
            }
        }
//        System.out.println(sb);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println(">>>MyInterceptor2>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println(">>>MyInterceptor2>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
