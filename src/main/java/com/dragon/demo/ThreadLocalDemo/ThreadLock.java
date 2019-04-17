package com.dragon.demo.ThreadLocalDemo;

/**
 * @author ljn
 * @date 2019/4/17.
 * 死锁
 */
public class ThreadLock {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        A b = new A();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("A锁:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println("B锁:" + Thread.currentThread().getName());
                    }
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("B锁:" + Thread.currentThread().getName());
                    synchronized (a) {
                        System.out.println("A锁:" + Thread.currentThread().getName());
                    }
                }
            }
        }.start();
    }
}
