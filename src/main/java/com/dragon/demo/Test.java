package com.dragon.demo;

import com.dragon.common.context.CurrentUserContext;
import com.dragon.common.enums.EnumSingleton;
import com.dragon.dao.entity.UserEO;

/**
 * @author ljn
 * @date 2019/3/29.
 */
public class Test {

    private Long a;

    public static void main(String[] args) {
        System.out.println(EnumSingleton.B.getType().toString());
        UserEO eo = new UserEO();
        System.out.println(eo.toString());

        UserEO user = CurrentUserContext.getUser();
        System.out.println(user);
        try {
            Class.forName("");
            System.out.println("1");
            System.out.println("2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        System.out.println(classLoader.getClass());




    }

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }


}
