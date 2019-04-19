package com.dragon.demo.factory;

/**
 * @author ljn
 * @date 2019/4/18.
 * Bean工厂
 */
public class PostFactory {

    public static Post getProvide(Integer msgType) {
        if (msgType == 1) {
            return new SendMsg();
        }
        if (msgType == 2) {
            return new SendEmail();
        }
        return null;
     }
}
