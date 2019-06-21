package com.dragon.demo.DesignPattern.ordinaryFactory.abstractFactory;

import com.dragon.demo.DesignPattern.ordinaryFactory.Sender;

/**
 * @author ljn
 * @date 2019/6/19.
 *
 * 抽象工厂模式
 */
public interface Provider {

    Sender produce();
}
