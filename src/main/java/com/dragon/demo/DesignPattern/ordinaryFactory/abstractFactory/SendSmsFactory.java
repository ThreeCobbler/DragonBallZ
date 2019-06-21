package com.dragon.demo.DesignPattern.ordinaryFactory.abstractFactory;

import com.dragon.demo.DesignPattern.ordinaryFactory.Sender;
import com.dragon.demo.DesignPattern.ordinaryFactory.SmsSender;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
