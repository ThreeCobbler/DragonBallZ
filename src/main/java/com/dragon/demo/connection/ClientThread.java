package com.dragon.demo.connection;

/**
 * @author ljn
 * @date 2019/3/28.
 */
public class ClientThread implements Runnable {

    @Override
    public void run() {
        ProduceService produceService = new ProduceService();
        System.out.println(Thread.currentThread().getName());
        try {
            System.out.println(produceService.execute());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
