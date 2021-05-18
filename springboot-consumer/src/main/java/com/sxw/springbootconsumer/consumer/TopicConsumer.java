package com.sxw.springbootconsumer.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue.example.topic.new", containerFactory = "v2ContainerFactory")
public class TopicConsumer {

    @RabbitHandler
    public void consumer(String message) {
        System.out.println(message);
    }
}
