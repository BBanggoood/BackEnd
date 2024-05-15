package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
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
        BBangVod bbangVod = new BBangVod();
        bbangVod.setBbangVodId(bbangVodId);
        bbangVodService.AddVod(bbangVod);
        return ResponseEntity.ok(bbangVod);
    }
}
