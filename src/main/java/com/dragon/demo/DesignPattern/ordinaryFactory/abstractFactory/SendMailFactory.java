package com.dragon.demo.DesignPattern.ordinaryFactory.abstractFactory;

import com.dragon.demo.DesignPattern.ordinaryFactory.MailSender;
import com.dragon.demo.DesignPattern.ordinaryFactory.Sender;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
