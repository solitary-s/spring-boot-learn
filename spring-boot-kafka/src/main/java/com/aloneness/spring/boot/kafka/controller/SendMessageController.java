package com.aloneness.spring.boot.kafka.controller;

import com.aloneness.spring.boot.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @GetMapping("send/{message}")
    public void sendMessage(@PathVariable String message) {
        kafkaTemplate.send("test", new Message("tong", message));
    }

}
