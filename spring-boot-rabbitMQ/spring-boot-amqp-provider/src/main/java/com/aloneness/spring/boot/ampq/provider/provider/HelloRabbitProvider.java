package com.aloneness.spring.boot.ampq.provider.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class HelloRabbitProvider {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now();
        System.out.println("Provider: " + context);
        amqpTemplate.convertAndSend("helloRabbit", context);
    }
}
