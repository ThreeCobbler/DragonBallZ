package com.dragon.demo.ThreadLocalDemo;

import com.dragon.dao.entity.UserEO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ljn
 * @date 2019/4/10.
 */
public class MapTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<? extends UserEO> userEOClass = UserEO.class;
        Field[] fields = userEOClass.getDeclaredFields();
        Method[] methods = userEOClass.getDeclaredMethods();
        for (Field field : fields) {
        }

        UserEO user = new UserEO();
        user.setUserName("jack");
        System.out.println("jack:" + user);
        UserEO user2 = new UserEO();
        user2.setUserName("rose");
        Map<UserEO,UserEO> map = new HashMap<>();
        map.put(user, user2);
        Set<UserEO> set = map.keySet();
        for (UserEO user3 : set) {
            System.out.println("user3" + user3);
        }
        Set<Map.Entry<UserEO, UserEO>> entries = map.entrySet();

        System.out.println("map"+map);
        user = null;
        System.out.println(user);
        System.out.println("map:--"+map);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stack : stackTrace) {
            System.out.println(stack);
        }
    }
}
