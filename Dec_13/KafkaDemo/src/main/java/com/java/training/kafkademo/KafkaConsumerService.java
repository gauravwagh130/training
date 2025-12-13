package com.java.training.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "demo-group")
    public void consume(String message) {
        System.out.println("Consumed Message" +message);
    }
}
