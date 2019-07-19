package com.dragon.demo.Observer;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
