package com.dragon.demo.lambda;

/**
 * @author ljn
 * @date 2019/5/13.
 */
@FunctionalInterface
public interface NameCheck {

    boolean check(Person p);
}
