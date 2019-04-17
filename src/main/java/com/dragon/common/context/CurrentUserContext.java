package com.dragon.common.context;

import com.dragon.dao.entity.UserEO;

/**
 * @author ljn
 * @date 2019/3/25.
 * 当前登录用户副本
 */
public class CurrentUserContext {

    private static ThreadLocal<UserEO> userThread = new ThreadLocal<UserEO>(){
        @Override
        protected UserEO initialValue() {
            return super.initialValue();
        }
    };

    private static ThreadLocal<String> msgThread = new InheritableThreadLocal<String>();

    public static void setUser(UserEO value) {
        userThread.set(value);
    }

    public static UserEO getUser() {
        return userThread.get();
    }

    public static void clear() {
        userThread.remove();
    }

    public static String getMsg() {
        return msgThread.get();
    }

    public static void set(String msg) {
        msgThread.set(msg);
    }


}
