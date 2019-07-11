package com.dragon.demo;

/**
 * @author ljn
 * @date 2019/7/10.
 */
public class TestCompare {

    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++){
            count++;
        }
        System.out.println(count);
    }
}
