package com.dragon.demo.Observer;

import com.dragon.demo.Observer.subject.MySubject;
import com.dragon.demo.Observer.subject.Subject;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }
}
