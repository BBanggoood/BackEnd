package com.bbanggood.springbbangupdate.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    // Topic
    private static final String VODADDTOPIC = "bbvodaddtopic";
    private static final String CASTADDTOPIC = "bbcastaddtopic";
    private static final String DIRECTORADDTOPIC = "bbdirectoraddtopic";

    private static final String VODDELETETOPIC = "bbvoddeletetopic";
    private static final String CASTDELETETOPIC = "bbcastdeletetopic";
    private static final String DIRECTORDELETETOPIC = "bbdirectordeletetopic";

    // Template
    private final KafkaTemplate<String, BBangVodMessage> kafkaVodAddTemplate;
    private final KafkaTemplate<String, BBangCastMessage> kafkaCastAddTemplate;
    private final KafkaTemplate<String, BBangDirectorMessage> kafkaDirectorAddTemplate;

    private final KafkaTemplate<String, BBangVodMessage> kafkaVodDeleteTemplate;
    private final KafkaTemplate<String, BBangCastMessage> kafkaCastDeleteTemplate;
    private final KafkaTemplate<String, BBangDirectorMessage> kafkaDirectorDeleteTemplate;

    // Message Function
    public void sendVodAddMessage(BBangVodMessage bbangCastMessage) {
        kafkaVodAddTemplate.send(VODADDTOPIC, bbangCastMessage);
    }
    public void sendCastAddMessage(BBangCastMessage bbangCastMessage) {
        kafkaCastAddTemplate.send(CASTADDTOPIC, bbangCastMessage);
    }
    public void sendDirectorAddMessage(BBangDirectorMessage bbangDirectorMessage) {
        kafkaDirectorAddTemplate.send(DIRECTORADDTOPIC, bbangDirectorMessage);
    }

    public void sendVodDeleteMessage(BBangVodMessage bbangVodMessage) {
        kafkaVodDeleteTemplate.send(VODDELETETOPIC, bbangVodMessage);
    }
    public void sendCastDeleteMessage(BBangCastMessage bbangCastMessage) {
        kafkaCastDeleteTemplate.send(CASTDELETETOPIC, bbangCastMessage);
    }
    public void sendDirectorDeleteMessage(BBangDirectorMessage bbangDirectorMessage) {
        kafkaDirectorDeleteTemplate.send(DIRECTORDELETETOPIC, bbangDirectorMessage);
    }
}