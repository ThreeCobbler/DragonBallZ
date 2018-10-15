package com.dragon.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ljn
 * @date 2018/10/12.
 */
@Configuration
public class RabbitConfigure {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    /**
     * 队列名称
     */
    public final static String SPRING_BOOT_QUEUE = "spring-boot-queue-1";
    public final static String SPRING_BOOT_QUEUE2 = "spring-boot-queue-2";

    /**
     * 交换机名称
     */
    public final static String SPRING_BOOT_EXCHANGE = "spring-boot-exchange-1";
    public final static String SPRING_BOOT_EXCHANGE2 = "spring-boot-exchange-2";

    /**
     * 绑定的值
     */
    public static final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key-1";
    public static final String SPRING_BOOT_BIND_KEY2 = "spring-boot-bind-key-2";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    /**
     *
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     *  FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     *  HeadersExchange ：通过添加属性key-value匹配
     *  DirectExchange:按照routingkey分发到指定队列
     *  TopicExchange:多关键字匹配
     * @return
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(SPRING_BOOT_EXCHANGE);
    }

    /**
     * 获取队列
     * @return
     */
    @Bean
    public Queue queueA() {
        //队列持久
        return new Queue(SPRING_BOOT_QUEUE, true);
    }

    @Bean
    public Queue queueB() {
        //队列持久
        return new Queue(SPRING_BOOT_QUEUE2, true);
    }

    /**
     * 一个交换机可以绑定多个消息队列，也就是消息通过一个交换机，可以分发到不同的队列当中去。
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(SPRING_BOOT_BIND_KEY);
    }

    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(defaultExchange()).with(SPRING_BOOT_BIND_KEY2);
    }

}
