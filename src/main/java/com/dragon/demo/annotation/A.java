package com.dragon.demo.annotation;

/**
 * @author ljn
 * @date 2018/5/17.
 */
public class A {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
