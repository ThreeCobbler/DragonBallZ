package com.dragon.demo.ThreadLocalDemo;

/**
 * @author ljn
 * @date 2019/4/17.
 */
public class A {

    public synchronized void test(String threadName) throws InterruptedException {
        System.out.println("A锁:" + threadName);
    }
}
