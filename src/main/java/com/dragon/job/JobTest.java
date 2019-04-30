package com.dragon.job;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @author ljn
 * @date 2019/4/29.
 */
@Component
public class JobTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 每隔两秒运行
     */
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void test() {
//        System.out.println(sdf.format(System.currentTimeMillis()));
//    }

}
