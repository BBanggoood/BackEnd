package com.bbanggood.springsignup.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    // Topic
    private static final String SIGNUPTOPIC = "usersignuptopic";
    private static final String UPDATETOPIC = "userupdatetopic";
    private static final String WITHDRAWTOPIC = "userwithdrawtopic";

    // Template
    private final KafkaTemplate<String, ChatMessage> kafkaSignUpTemplate;
    private final KafkaTemplate<String, ChatMessage> kafkaUpdateTemplate;
    private final KafkaTemplate<String, ChatMessage> kafkaWithdrawTemplate;

    // Message Function
    public void sendSignUpMessage(ChatMessage chatmessage) {
        kafkaSignUpTemplate.send(SIGNUPTOPIC, chatmessage);
    }
    public void sendUpdateMessage(ChatMessage chatmessage) {
        kafkaUpdateTemplate.send(UPDATETOPIC, chatmessage);
    }
    public void sendWithdrawMessage(ChatMessage chatmessage) {
        kafkaWithdrawTemplate.send(WITHDRAWTOPIC, chatmessage);
    }
}