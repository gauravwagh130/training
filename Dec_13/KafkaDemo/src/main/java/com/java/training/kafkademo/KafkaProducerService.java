package com.java.training.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static final  String TOPIC = "test-topic";
    public void sendMessage(String message){
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Produced message: " + message);
    }
}
