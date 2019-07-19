package com.dragon.demo.Observer;

import java.util.Arrays;
import java.util.List;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
        List<Long> longs = Arrays.asList(new Long[5]);
        Long[] longs1 = longs.toArray(new Long[5]);

    }

}
