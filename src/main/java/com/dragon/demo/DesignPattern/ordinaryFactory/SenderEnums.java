package com.dragon.demo.DesignPattern.ordinaryFactory;

/**
 * @author ljn
 * @date 2019/6/19.
 */
public enum SenderEnums {

    Mail(1, "邮件"),

    Sms(2, "短信");

    private int type;

    private String sendName;

    public int getType() {
        return type;
    }

    public String getSendName() {
        return sendName;
    }

    SenderEnums(int type, String sendName) {
        this.type = type;
        this.sendName = sendName;
    }

    public static SenderEnums getSendNameByType(int type) {
        for (SenderEnums sender : SenderEnums.values()) {
            if (type == sender.getType()) {
                return sender;
            }
        }
        throw new IllegalArgumentException("找到该类型的Sender枚举");
    }
}
