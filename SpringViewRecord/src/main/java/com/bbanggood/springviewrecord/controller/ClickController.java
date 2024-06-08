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

@Slf4j
@Data
@RestController
@RequestMapping("/view-record")
public class ClickController {
    private final ClickService clickService;
    private final KafkaProducerService producerService;

    @PostMapping("/click")
    public String AddClickRecord(@RequestBody ClickDTO click, BindingResult bindingResult, ClickMessage clickMessage) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        // 카프카 연동
        clickMessage.setSetbxId(click.getSetbxId().toString());
        clickMessage.setVodId(click.getVodId());
        clickMessage.setViewType(click.getViewType());
        clickMessage.setClickTime(click.getClickTime());
        producerService.sendClickMessage(clickMessage);

        clickService.ClickPost(click.getSetbxId(), click.getVodId(), click.getViewType(), click.getClickTime());

        return "클릭 입력 완료";
    }
}
