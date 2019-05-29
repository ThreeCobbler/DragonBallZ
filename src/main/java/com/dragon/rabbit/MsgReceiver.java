package com.dragon.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ljn
 * @date 2018/10/12.
 */
@Component
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RabbitHandler
    @RabbitListener(queues = RabbitConfigure.SPRING_BOOT_QUEUE)
    public void process(String content) {
        logger.info("接收处理队列A当中的消息： " + content);
        System.out.println(content);
    }
}
