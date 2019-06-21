package com.dragon.demo.DesignPattern.ordinaryFactory.builder;

/**
 * @author ljn
 * @date 2019/6/20.
 * 建造者模式测试
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(2);
        System.out.println("");
    }
}
