package com.dragon.common.enums;

/**
 * Created by 339939 on 2018/5/3.
 */
public enum OrderStatus {

    WaitPay(1,"待付款"),

    AlreadyPay(2,"已付款"),

    WaitDelivery(3,"待发货"),

    Trading(4,"交易中"),

    Cancel(5,"取消"),

    Success(6,"成功");

    private int code;

    private String status;

    OrderStatus(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public static OrderStatus getStatusByCode(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("未能找到匹配的OrderState:" + code);
    }
}
