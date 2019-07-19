package com.dragon.demo.ResponsibilityChain;

/**
 * @author ljn
 * @date 2019/7/16.
 */
public abstract class AbstractHandler  {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
