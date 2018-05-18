package com.dragon.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ljn
 * @date 2018/5/17.
 */
public class B {

    public static void main(String[] args) {

        HashSet<String> strings = new HashSet<>();
        List<A> list = new ArrayList<A>();
        for (int i = 0;i < 5;i++) {
            list.add(new A("id"+i,"name"+i));
        }
        list.forEach(System.out::println);
        list.stream().collect(Collectors.toMap(A::getId,A::getName)).forEach((k, v)->{
            System.out.println(k+"/"+v);
        });
    }

}
