package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
import com.bbanggood.springbbangupdate.entity.UserMysql;
import com.bbanggood.springbbangupdate.entity.Vod;
import com.bbanggood.springbbangupdate.service.BBangVodService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/bbang")
public class BBangVodController {
    private final BBangVodService bbangVodService;

    @PostMapping("/add/vod")
    public ResponseEntity<BBangVod> addVod(@RequestBody BBangVodId bbangVodId) {
        BBangVod bbangVod = bbangVodService.AddVod(bbangVodId.getSetbxId(), bbangVodId.getVodId());
        return ResponseEntity.ok(bbangVod);
    }

    @DeleteMapping("/delete/vod")
    public ResponseEntity<String> deleteVod(@RequestBody BBangVodId bbangVodId) {
        try {
            bbangVodService.DeleteVod(bbangVodId.getSetbxId(), bbangVodId.getVodId());
            return ResponseEntity.ok().body("User with setbxId " + bbangVodId.getSetbxId() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
