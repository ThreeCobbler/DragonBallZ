package com.dragon.demo.Observer.subject;

import com.dragon.demo.Observer.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }


}
