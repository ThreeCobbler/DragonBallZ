package com.dragon.demo.lambda;

/**
 * @author ljn
 * @date 2019/5/13.
 */
public class MyInterfaceImpl implements MyLambdaInterface {
    @Override
    public void doSomething(String s) {
        System.out.println(s);
    }
}
