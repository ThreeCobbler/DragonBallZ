package com.dragon.demo;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ljn
 * @date 2019/4/29.
 */
public class ATest {

    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;

    private static final long MICROS_PER_DAY
            = 24 * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        long a  = MILLIS_PER_DAY;
        long b = MICROS_PER_DAY;

        System.out.println(b / a);

        Set set = new LinkedHashSet<>();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
