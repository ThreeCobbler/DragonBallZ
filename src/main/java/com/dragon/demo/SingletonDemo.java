package com.dragon.demo;

/**
 * @author ljn
 * @date 2019/7/15.
 */
public class SingletonDemo {

    private static volatile SingletonDemo singleton = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (singleton != null) {
            return singleton;
        }
        synchronized(SingletonDemo.class) {
            if (singleton != null) {
                return singleton;
            }
            return new SingletonDemo();
        }

    }




}
