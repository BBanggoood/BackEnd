package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangVodDTO;
import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.service.BBangVodService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbanggood.springbbangupdate.kafka.BBangVodMessage;
import com.bbanggood.springbbangupdate.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RestController
@RequestMapping("/bbang")
public class BBangVodController {
    private final BBangVodService bbangVodService;
    private final KafkaProducerService producerService;

    @PostMapping("/vod")
    public ResponseEntity<BBangVod> addVod(@RequestBody BBangVodDTO bbangVodDTO, BBangVodMessage bbangVodMessage) {
        BBangVod bbangVod = bbangVodService.AddVod(bbangVodDTO.getSetbxId(), bbangVodDTO.getVodId(), bbangVodDTO.getVodPoster());

        // 카프카 연동
        bbangVodMessage.setSetbxId(bbangVod.getSetbxId().toString());
        bbangVodMessage.setVodId(bbangVod.getVodId());
        bbangVodMessage.setVodPoster(bbangVod.getVodPoster());
        producerService.sendVodAddMessage(bbangVodMessage);

        return ResponseEntity.ok(bbangVod);
    }

    @DeleteMapping("/vod")
    public ResponseEntity<String> deleteVod(@RequestBody BBangVodDTO bbangVodDTO, BBangVodMessage bbangVodMessage) {
        try {
            bbangVodService.DeleteVod(bbangVodDTO.getSetbxId(), bbangVodDTO.getVodId());

            // 카프카 연동
            bbangVodMessage.setSetbxId(bbangVodDTO.getSetbxId().toString());
            bbangVodMessage.setVodId(bbangVodDTO.getVodId());
            producerService.sendVodDeleteMessage(bbangVodMessage);

            return ResponseEntity.ok().body("User " + bbangVodDTO.getSetbxId() + " with vodId " + bbangVodDTO.getVodId() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
