package com.dragon.common.context;

import com.dragon.dao.entity.UserEO;

/**
 * @author ljn
 * @date 2019/3/25.
 */
public class CurrentUser {

    private static ThreadLocal<UserEO> userThread = new ThreadLocal<UserEO>();

    public static void setUser(UserEO value) {
        userThread.set(value);
    }

    public static UserEO getUser() {
        return userThread.get();
    }

    public static void clear() {
        userThread.remove();
    }

}
