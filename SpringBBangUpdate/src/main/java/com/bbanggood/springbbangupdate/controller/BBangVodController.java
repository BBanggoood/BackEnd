package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangVodDTO;
import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.service.BBangVodService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/bbang")
public class BBangVodController {
    private final BBangVodService bbangVodService;

    @PostMapping("/vod")
    public ResponseEntity<BBangVod> addVod(@RequestBody BBangVodDTO bbangVodDTO) {
        BBangVod bbangVod = bbangVodService.AddVod(bbangVodDTO.getSetbxId(), bbangVodDTO.getVodId(), bbangVodDTO.getVodPoster());
        return ResponseEntity.ok(bbangVod);
    }

    @DeleteMapping("/vod")
    public ResponseEntity<String> deleteVod(@RequestBody BBangVodDTO bbangVodDTO) {
        try {
            bbangVodService.DeleteVod(bbangVodDTO.getSetbxId(), bbangVodDTO.getVodId());
            return ResponseEntity.ok().body("User " + bbangVodDTO.getSetbxId() + " with vodId " + bbangVodDTO.getVodId() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
