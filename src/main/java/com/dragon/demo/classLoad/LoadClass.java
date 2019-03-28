package com.dragon.demo.classLoad;

/**
 * @author ljn
 * @date 2019/3/27.
 */
public class LoadClass {

    public static void main(String[] args) {
        //获取类对象的时候，没有加载类
        Class<ClassObject> aClass = ClassObject.class;
        System.out.println(aClass);

        ClassObject a = new ClassObject();
    }
}
