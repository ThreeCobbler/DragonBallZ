package com.dragon.demo.count;

import java.math.BigInteger;

/**
 * @author ljn
 * @date 2019/5/10.
 */
public class Count {

    public static void main(String[] args) {

        String s = "";
        for (int i = 0;i<2014;i++) {
            s+="1";
        }
        BigInteger a = new BigInteger(s);
        BigInteger remainder = a.remainder(new BigInteger("7"));
        System.out.println(remainder);

    }
}
