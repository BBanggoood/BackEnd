package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangDirectorDTO;
import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangDirectorService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbanggood.springbbangupdate.kafka.BBangDirectorMessage;
import com.bbanggood.springbbangupdate.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RestController
@RequestMapping("bbang")
public class BBangDirectorController {
    private final BBangDirectorService bbangDirectorService;
    private final KafkaProducerService producerService;

    @PostMapping("/director")
    public ResponseEntity<BBangDirector> addDirector(@RequestBody BBangDirectorDTO bbangDirectorDTO, BBangDirectorMessage bbangDirectorMessage) {
        BBangDirector bbangDirector = bbangDirectorService.AddDirector(bbangDirectorDTO.getSetbxId(),
                bbangDirectorDTO.getVodDirector(), bbangDirectorDTO.getVodDirectorPoster());

        // 카프카 연동
        bbangDirectorMessage.setSetbxId(bbangDirector.getSetbxId().toString());
        bbangDirectorMessage.setVodDirector(bbangDirector.getVodDirector());
        bbangDirectorMessage.setVodDirectorPoster(bbangDirector.getVodDirectorPoster());
        producerService.sendDirectorAddMessage(bbangDirectorMessage);

        return ResponseEntity.ok(bbangDirector);
    }

    @DeleteMapping("/director")
    public ResponseEntity<String> deleteDirector(@RequestBody BBangDirectorDTO bbangDirectorDTO, BBangDirectorMessage bbangDirectorMessage) {
        try {
            bbangDirectorService.DeleteDirector(bbangDirectorDTO.getSetbxId(), bbangDirectorDTO.getVodDirector());

            // 카프카 연동
            bbangDirectorMessage.setSetbxId(bbangDirectorDTO.getSetbxId().toString());
            bbangDirectorMessage.setVodDirector(bbangDirectorDTO.getVodDirector());
            producerService.sendDirectorDeleteMessage(bbangDirectorMessage);

            return ResponseEntity.ok().body("User " + bbangDirectorDTO.getSetbxId() + " with vodDirector " + bbangDirectorDTO.getVodDirector() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
