package com.aloneness.spring.boot.ampq.provider.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue queue(){
        return new Queue("helloRabbit");
    }
}
