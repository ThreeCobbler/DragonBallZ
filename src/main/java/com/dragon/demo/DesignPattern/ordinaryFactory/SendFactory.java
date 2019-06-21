package com.dragon.demo.DesignPattern.ordinaryFactory;

/**
 * @author ljn
 * @date 2019/6/19.
 * 将工厂方法静态化，就成了静态工厂模式
 */
public class SendFactory {

    public static Sender produce(int type) {
        if (type == SenderEnums.Mail.getType()) {
            return new MailSender();
        }else if (type == SenderEnums.Sms.getType()) {
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }

    }

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}
