package com.dragon.controller.impl;

import com.dragon.email.IMailService;
import com.dragon.email.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljn
 * @date 2019/4/19.
 */
@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private IMailService mailService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public void sendMailMessage(@RequestParam String messageCode,@RequestParam String messageStatus,@RequestParam String cause) {
        Message message = new Message();
        message.setMessageCode(messageCode);
        message.setMessageStatus(messageStatus);
        message.setCause(cause);
        mailService.sendMessageMail(message, "测试消息通知", "message.ftl");
    }
}
