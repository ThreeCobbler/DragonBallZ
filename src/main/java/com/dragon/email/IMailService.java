package com.dragon.email;

/**
 * @author ljn
 * @date 2019/4/19.
 */
public interface IMailService {

    /**
     * 发送邮件
     * @param params
     * @param title
     * @param templateName
     */
    void sendMessageMail(Object params, String title, String templateName) ;
}
