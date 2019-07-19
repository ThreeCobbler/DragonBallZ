package com.dragon.demo.Observer.subject;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
