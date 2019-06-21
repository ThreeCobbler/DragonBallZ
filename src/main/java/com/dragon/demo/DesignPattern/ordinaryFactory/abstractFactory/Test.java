package com.dragon.demo.DesignPattern.ordinaryFactory.abstractFactory;

import com.dragon.demo.DesignPattern.ordinaryFactory.Sender;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public class Test {

    public static void main(String[] args) {
        Provider sendMailFactory = new SendMailFactory();
        Sender sender = sendMailFactory.produce();
        sender.send();
    }
}
