package com.dragon.demo.factory;

/**
 * @author ljn
 * @date 2019/4/18.
 */
public class SendEmail implements Post{
    @Override
    public void send(String msg) {
        System.out.println("发送邮件");
    }
}
