package com.dragon.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * Created by 339939 on 2018/3/26.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

//    @Autowired
//    private MyInterceptor1 myInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(myInterceptor1()).addPathPatterns(Arrays.asList(
                "/user/logout"
        ));
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public MyInterceptor1 myInterceptor1(){
        return new MyInterceptor1();
    }


}
