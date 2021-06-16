package com.aloneness.spring.boot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = {"test"})
//    public void listen(ConsumerRecord<?, ?> record) {
//        Optional.ofNullable(record.value())
//                .ifPresent(message -> {
//                    log.info("record = {}", record);
//                    log.info("message = {}", message);
//                });
//    }

}
