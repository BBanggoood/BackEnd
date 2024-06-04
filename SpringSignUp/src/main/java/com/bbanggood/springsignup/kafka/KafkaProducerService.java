package com.bbanggood.springsignup.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private static final String TOPIC = "usertopic";
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;
    public void sendMessage(ChatMessage chatmessage) {
        kafkaTemplate.send(TOPIC, chatmessage);
    }
}