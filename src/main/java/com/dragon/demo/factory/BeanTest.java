package com.dragon.demo.factory;

/**
 * @author ljn
 * @date 2019/4/18.
 */
public class BeanTest {

    public static void main(String[] args) {
        Post provide = PostFactory.getProvide(1);
        provide.send("text");
        Post provide2 = PostFactory.getProvide(2);
        provide2.send("text");
    }
}
