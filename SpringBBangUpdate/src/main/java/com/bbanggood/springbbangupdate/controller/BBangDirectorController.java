package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.BBangCast;
import com.bbanggood.springbbangupdate.entity.BBangCastId;
import com.bbanggood.springbbangupdate.entity.BBangDirector;
import com.bbanggood.springbbangupdate.entity.BBangDirectorId;
import com.bbanggood.springbbangupdate.service.BBangDirectorService;
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
public class BBangDirectorController {
    private final BBangDirectorService bbangDirectorService;

    @PostMapping("/add/director")
    public ResponseEntity<BBangDirector> addDirector(@RequestBody BBangDirectorId bbangDirectorId) {
        BBangDirector bbangDirector = bbangDirectorService.AddDirector(bbangDirectorId.getSetbxId(), bbangDirectorId.getVodDirector());
        return ResponseEntity.ok(bbangDirector);
    }
}
