package com.dragon.demo;

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




    }

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }


}
