package com.dragon.demo;

/**
 * @author ljn
 * @date 2019/7/10.
 */
public class Confusing {

    public Confusing(Object o) {
        System.out.println("Object");
    }
    public Confusing(double[] dArray) {
        System.out.println("double array");
    }
    public static void main(String args[]) {
        new Confusing(null);
    }
}
