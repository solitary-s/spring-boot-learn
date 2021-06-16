package com.aloneness.spring.boot.kafka.sender;

import com.aloneness.spring.boot.kafka.domain.User;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class KafkaProducer {

//    @Resource
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @Value("${kafka.topic.user}")
//    private String topicUser;
//
//    public void sendUserMessage(User user) {
//        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
//        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        String message = builder.create().toJson(user);
//        kafkaTemplate.send(topicUser, message);
//        log.info("\n生产消息至Kafka\n" + message);
//    }
}
