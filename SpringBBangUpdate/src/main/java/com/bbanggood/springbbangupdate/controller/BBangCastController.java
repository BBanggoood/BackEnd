package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangCastDTO;
import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangCastService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbanggood.springbbangupdate.kafka.BBangCastMessage;
import com.bbanggood.springbbangupdate.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RestController
@RequestMapping("bbang")
public class BBangCastController {
    private final BBangCastService bbangCastService;
    private final KafkaProducerService producerService;

    @PostMapping("/cast")
    public ResponseEntity<BBangCast> addCast(@RequestBody BBangCastDTO bbangCastDTO, BBangCastMessage bbangCastMessage) {
        BBangCast bbangCast = bbangCastService.AddCast(bbangCastDTO.getSetbxId(), bbangCastDTO.getVodCast(), bbangCastDTO.getVodCastPoster());

        // 카프카 연동
        bbangCastMessage.setSetbxId(bbangCast.getSetbxId().toString());
        bbangCastMessage.setVodCast(bbangCast.getVodCast());
        bbangCastMessage.setVodCastPoster(bbangCast.getVodCastPoster());
        producerService.sendCastAddMessage(bbangCastMessage);

        return ResponseEntity.ok(bbangCast);
    }

    @DeleteMapping("/cast")
    public ResponseEntity<String> deleteCast(@RequestBody BBangCastDTO bbangCastDTO, BBangCastMessage bbangCastMessage) {
        try {
            bbangCastService.DeleteCast(bbangCastDTO.getSetbxId(), bbangCastDTO.getVodCast());

            // 카프카 연동
            bbangCastMessage.setSetbxId(bbangCastDTO.getSetbxId().toString());
            bbangCastMessage.setVodCast(bbangCastDTO.getVodCast());
            producerService.sendCastDeleteMessage(bbangCastMessage);

            return ResponseEntity.ok().body("User " + bbangCastDTO.getSetbxId() + " with vodCast " + bbangCastDTO.getVodCast() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
