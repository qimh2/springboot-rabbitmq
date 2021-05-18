package com.sxw.springbootproducer;

import com.sxw.springbootproducer.producer.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQMultipleTest {

    @Autowired
    private TopicProducer topicProducer;


    @Test
    public void topicProducerTest() {
        topicProducer.sendMessageByTopic();
    }
}
