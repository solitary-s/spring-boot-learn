package com.aloneness.spring.boot.kafka.listener;

import com.aloneness.spring.boot.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "test", groupId = "test-consumer")
    public void listen(Message message) {
        log.info("接收消息：{}", message);
    }

}
