package com.dragon.demo.DesignPattern.ordinaryFactory;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
