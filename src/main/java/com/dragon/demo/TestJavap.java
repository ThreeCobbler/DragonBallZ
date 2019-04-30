package com.dragon.demo;

/**
 * @author ljn
 * @date 2019/4/28.
 */
public class TestJavap {

    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 99; i++) {
            a = a++;
        }
        System.out.println(a);



        System.out.println("----------------");
        Integer c = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            c = c ++;
            b = c ++;
        }
        System.out.println(c);
        System.out.println(b);

        System.out.println("----------------");
        String[] arr = "aaa.bbb.ccc".split("\\.");
        System.out.println(arr.length);

        int i = 3,j=4;
        int x = i < j ? null : 0;
    }
}
