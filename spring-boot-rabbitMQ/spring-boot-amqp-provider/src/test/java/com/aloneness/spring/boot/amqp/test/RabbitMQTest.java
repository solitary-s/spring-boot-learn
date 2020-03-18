package com.aloneness.spring.boot.amqp.test;


import com.aloneness.spring.boot.ampq.provider.SpringBootAmqpProvider;
import com.aloneness.spring.boot.ampq.provider.provider.HelloRabbitProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAmqpProvider.class)
public class RabbitMQTest {

    @Autowired
    private HelloRabbitProvider helloRabbitProvider;

    @Test
    public void testSender() {
        for (int i = 0; i < 10; i++) {
            helloRabbitProvider.send();
        }
    }
}
