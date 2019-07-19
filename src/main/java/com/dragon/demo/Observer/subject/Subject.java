package com.dragon.demo.Observer.subject;

import com.dragon.demo.Observer.Observer;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public interface Subject {

    /**
     * 增加观察者
     * @param observer
     */
    void add(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void delete(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

    /**
     * 自身的操作
     */
    void operation();


}
