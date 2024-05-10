package com.bbanggood.springsignup;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "sampletopic", groupId = "bbanggoodgroup", containerFactory =
            "kafkaListener")
    public void consume(ChatMessage message){
        System.out.println("name = " + message.getName());
        System.out.println("age = " + message.getAge());
    }
}