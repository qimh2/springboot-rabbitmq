package com.sxw.springbootconsumer.config.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 创建Queue、Exchange并建立绑定关系
 * Created by shuai on 2019/5/16.
 */
public class MyRabbitMQCreateConfig {
    @Resource(name = "v2RabbitAdmin")
    private RabbitAdmin v2RabbitAdmin;

    @Resource(name = "v1RabbitAdmin")
    private RabbitAdmin v1RabbitAdmin;

    @PostConstruct
    public void RabbitInit() {
        v2RabbitAdmin.declareExchange(new TopicExchange("exchange.topic.example.new", true, false));
        v2RabbitAdmin.declareQueue(new Queue("queue.example.topic.new", true));
        v2RabbitAdmin.declareBinding(
                BindingBuilder
                        .bind(new Queue("queue.example.topic.new", true))        //直接创建队列
                        .to(new TopicExchange("exchange.topic.example.new", true, false))    //直接创建交换机 建立关联关系
                        .with("routing.key.example.new"));    //指定路由Key
    }

}
