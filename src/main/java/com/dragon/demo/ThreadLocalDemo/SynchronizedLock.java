package com.dragon.demo.ThreadLocalDemo;

/**
 * @author ljn
 * @date 2019/4/18.
 */
public class SynchronizedLock {

    private int num = 0;

    public void add () {
        this.num = 10;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
