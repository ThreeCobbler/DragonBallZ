package com.dragon.demo.ThreadLocalDemo;

/**
 * @author ljn
 * @date 2019/4/17.
 */
public class B {

    public synchronized void test(String threadName) throws InterruptedException {
        System.out.println("B锁:" + threadName);
    }
}
