package com.bbanggood.springviewrecord.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    // Topic
    private static final String CLICKTOPIC = "clicktopic";
    private static final String LOGTOPIC = "logtopic";
    private static final String RATINGTOPIC = "ratingtopic";

    // Template
    private final KafkaTemplate<String, ClickMessage> kafkaClickTemplate;
    private final KafkaTemplate<String, LogMessage> kafkaLogTemplate;
    private final KafkaTemplate<String, RatingMessage> kafkaRatingTemplate;

    // Message Function
    public void sendClickMessage(ClickMessage clickMessage) {
        kafkaClickTemplate.send(CLICKTOPIC, clickMessage);
    }
    public void sendLogMessage(LogMessage logMessage) {
        kafkaLogTemplate.send(LOGTOPIC, logMessage);
    }
    public void sendRatingMessage(RatingMessage ratingMessage) {
        kafkaRatingTemplate.send(RATINGTOPIC, ratingMessage);
    }
}
