package com.dragon.demo.classLoad;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ljn
 * @date 2019/4/15.
 */
public class ReflectionDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<BeanClass> aClass = BeanClass.class;
        Class<BeanClass> clazz = BeanClass.class;
        Class[] classes = new Class[]{String.class};
        Constructor<BeanClass> constructor = aClass.getConstructor(classes);
        BeanClass aa = constructor.newInstance("有参构造实例对象");
        System.out.println(aa.getMessage());
        Constructor<?>[] constructors = aClass.getConstructors();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Constructor<BeanClass> constructor1 = clazz.getDeclaredConstructor();
        constructor1.setAccessible(true);
        BeanClass instance = constructor1.newInstance();
        System.out.println(instance.getMessage());
    }

}
