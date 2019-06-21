package com.dragon.demo.DesignPattern.ordinaryFactory;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("发送邮件");
    }
}
