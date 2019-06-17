package com.dragon.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljn
 * @date 2019/6/14.
 * ReentrantLock 可重入锁
 * 与 synchronized 相比，重入锁有着显示的操作过程，何时加锁，何时释放，都在程序员的控制中。
 * 这种锁是可以反复进入的。将下面代码中注释部分去除注释，也就是连续两次获得同一把锁，两次释放同一把锁，这是允许的。
 *
 * 注意，获得锁次数与释放锁次数要相同，如果释放锁次数多了，会抛出 java.lang.IllegalMonitorStateException 异常；
 * 如果释放次数少了，相当于线程还持有这个锁，其他线程就无法进入临界区。
 */
public class ReenterLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    private static int i = 0;
    @Override
    public void run() {
        for (int j= 0;j<10000;j++) {
            lock.lock();
//            lock.lock();
            try{
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }finally {
                lock.unlock();
//                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenter = new ReenterLock();
        Thread t1 = new Thread(reenter);
        Thread t2 = new Thread(reenter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
