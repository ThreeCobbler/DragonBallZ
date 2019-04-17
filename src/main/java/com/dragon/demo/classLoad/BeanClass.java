package com.dragon.demo.classLoad;

/**
 * @author ljn
 * @date 2019/4/15.
 */
public class BeanClass {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BeanClass(String message) {
        this.message = message;
    }

    private BeanClass() {
        this.message="无参构造方法实例化bean";
    }
}
