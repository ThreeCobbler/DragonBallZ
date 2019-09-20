package com.dragon.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 339939 on 2018/3/26.
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor2 myInterceptor2;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        this.addIgnoreList();
        registry.addInterceptor(myInterceptor1()).addPathPatterns("/**").excludePathPatterns("/login", "/register");
//      registry.addInterceptor(myInterceptor2).addPathPatterns("/**");
    }

    @Bean
    public MyInterceptor1 myInterceptor1(){
        return new MyInterceptor1();
    }

    private void addIgnoreList() {
        List<String> list = Arrays.asList(
                "/dragonBall/index.html",
                "/dragonBall/upload",
                "/dragonBall/upload.html",
                "/dragonBall/user/add",
                "/dragonBall/user/login",
                "/dragonBall/user/checkUser",
                "/dragonBall/ziliao.txt",
                "/dragonBall/demo/test2",
                "/dragonBall/user/findById",
                "/dragonBall/user/getUserList"
        );
        this.myInterceptor1().setIgnoreList(list);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }
}
