package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.LogDTO;
import com.bbanggood.springviewrecord.kafka.LogMessage;
import com.bbanggood.springviewrecord.service.LogService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bbanggood.springviewrecord.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
@RestController
@RequestMapping("/view-record")
public class LogController {
    private final LogService logService;
    private final KafkaProducerService producerService;

    @PostMapping("/log")
    public String AddLogRecord(@RequestBody LogDTO log, BindingResult bindingResult, LogMessage logMessage) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        // 카프카 연동
        logMessage.setSetbxId(log.getSetbxId().toString());
        logMessage.setVodName(log.getVodName());
        logMessage.setWatchTime(log.getWatchTime().toString());
        logMessage.setStartTime(log.getStartTime().toString());
        logMessage.setEndTime(LocalDateTime.now().toString());
        producerService.sendLogMessage(logMessage);

        logService.LogPost(log.getSetbxId(), log.getVodName(), log.getWatchTime(), log.getStartTime(), log.getEndTime());

        return "로그 입력 완료";
    }
}
