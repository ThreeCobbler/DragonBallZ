package com.dragon;

import com.dragon.rabbit.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ljn
 * @date 2019/5/29.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMq {

    @Autowired
    MsgProducer producer;

    @Test
    public void send() {
        producer.sendMsg("一看到它，他就不存在了");
    }
}
