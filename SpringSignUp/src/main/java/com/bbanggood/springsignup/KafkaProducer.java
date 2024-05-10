// 보내는 애
package com.bbanggood.springsignup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "sampletopic"; // 토픽 이름 맞춰줘야 됨!

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public void sendMessage(String name, int age) {
        log.info("Produce message : {}{}", name, age);
        String message = "{\"name\":" + "\"" + name + "\"" + ", \"age\":" + age +
                "}";
        this.kafkaTemplate.send(TOPIC, message);
    }
}