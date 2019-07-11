package com.dragon.demo;

import java.util.Arrays;

/**
 * @author ljn
 * @date 2019/7/10.
 */
public class Tencent {

    public static void main(String[] args) {
        int[] ints = makePi(100);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] makePi(int length) {
        int[] arr = new int[length];
//        String substring = (String.valueOf(PI)).substring(0, length + 1);
//        for (int i = 0,k=0, j = substring.length();i < j;i++) {
//            if (i == 1) {
//                continue;
//            }
//            arr[k] = Integer.valueOf(substring.charAt(i) + "");
//            k++;
//        }
        for (int i = 0;i<length;i++) {
            arr[i] = (int)(Math.PI * (Math.pow(10,i)) % 10);
        }


        return arr;
    }
}
