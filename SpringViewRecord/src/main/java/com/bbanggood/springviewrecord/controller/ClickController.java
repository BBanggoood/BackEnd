package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.ClickDTO;
import com.bbanggood.springviewrecord.kafka.ClickMessage;
import com.bbanggood.springviewrecord.service.ClickService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbanggood.springviewrecord.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Data
@RestController
@RequestMapping("/view-record")
public class ClickController {
    private final ClickService clickService;
    private final KafkaProducerService producerService;

    @PostMapping("/click")
    public String AddClickRecord(@RequestBody ClickDTO click, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        // 카프카 연동
        ClickMessage clickMessage = new ClickMessage();
        clickMessage.setSetbxId(click.getSetbxId().toString());
        clickMessage.setVodName(click.getVodName());
        clickMessage.setViewType(click.getViewType());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//        clickMessage.setClickTime(LocalDateTime.now().toString());
        clickMessage.setClickTime(LocalDateTime.now().format(formatter));

        producerService.sendClickMessage(clickMessage);

        clickService.ClickPost(click.getSetbxId(), click.getVodName(), click.getViewType(), LocalDateTime.parse(clickMessage.getClickTime(), formatter));

        return "클릭 입력 완료";
    }
}
