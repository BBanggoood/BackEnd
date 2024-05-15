package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.BBangCast;
import com.bbanggood.springbbangupdate.entity.BBangCastId;
import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
import com.bbanggood.springbbangupdate.service.BBangCastService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("bbang")
public class BBangCastController {
    private final BBangCastService bbangCastService;

    @PostMapping("/add/cast")
    public ResponseEntity<BBangCast> addCast(@RequestBody BBangCastId bbangCastId) {
        BBangCast bbangCast = bbangCastService.AddCast(bbangCastId.getSetbxId(), bbangCastId.getVodCast());
        return ResponseEntity.ok(bbangCast);
    }
}
