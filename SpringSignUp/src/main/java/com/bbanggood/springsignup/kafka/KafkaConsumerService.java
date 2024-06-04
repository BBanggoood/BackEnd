package com.bbanggood.springsignup.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "usertopic", groupId = "bbanggoodgroup", containerFactory =
            "kafkaListener")
    public void consume(ChatMessage message){
        System.out.println("setbxId = " + message.getUserSetbxId());
        System.out.println("email = " + message.getUserEmail());
        System.out.println("password = " + message.getUserPwd());
        System.out.println("name = " + message.getUserName());
        System.out.println("phone = " + message.getUserPhone());
        System.out.println("sex = " + message.getUserSex());
        System.out.println("birth = " + message.getUserBirth());

    }
}