package com.dragon.demo.lambda;

/**
 * @author ljn
 * @date 2019/5/13.
 * 只有一个接口函数需要被实现的接口类型，我们叫它”函数式接口
 * 加上@FunctionalInterface，别人就无法在里面添加新的接口函数
 */
@FunctionalInterface
public interface MyLambdaInterface {

    void doSomething(String s);
}
