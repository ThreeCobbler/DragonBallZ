package com.dragon.demo.ThreadLocalDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljn
 * @date 2019/4/18.
 */
public class Test {

    public static void main(String[] args) {
        SynchronizedLock demo = new SynchronizedLock();
        new Thread(() ->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.add();
        }).start();

        while (demo.getNum() == 0) {
            System.out.println("num:");
        }
        System.out.println("num:" + demo.getNum());

        List list = new ArrayList<>();
        list.add("a");
        list.stream().forEach(a -> {
            System.out.println(a);
        });
    }


}
