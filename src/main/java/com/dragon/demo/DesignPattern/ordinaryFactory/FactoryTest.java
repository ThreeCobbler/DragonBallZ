package com.dragon.demo.DesignPattern.ordinaryFactory;

/**
 * @author ljn
 * @date 2019/6/19.
 * 工厂模式测试
 */
public class FactoryTest {

    public static void main(String[] args) {
        //简单工厂模式
        Sender sender = SendFactory.produce(SenderEnums.Mail.getType());
        sender.send();

        //多个工厂模式
        Sender mailSender = SendFactory.produceMail();
        mailSender.send();
    }
}
