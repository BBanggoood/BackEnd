package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangCastDTO;
import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangCastService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("bbang")
public class BBangCastController {
    private final BBangCastService bbangCastService;

    @PostMapping("/cast")
    public ResponseEntity<BBangCast> addCast(@RequestBody BBangCastDTO bbangCastDTO) {
        BBangCast bbangCast = bbangCastService.AddCast(bbangCastDTO.getSetbxId(), bbangCastDTO.getVodCast(), bbangCastDTO.getVodCastPoster());
        return ResponseEntity.ok(bbangCast);
    }

    @DeleteMapping("/cast")
    public ResponseEntity<String> deleteCast(@RequestBody BBangCastDTO bbangCastDTO) {
        try {
            bbangCastService.DeleteCast(bbangCastDTO.getSetbxId(), bbangCastDTO.getVodCast());
            return ResponseEntity.ok().body("User " + bbangCastDTO.getSetbxId() + " with vodCast " + bbangCastDTO.getVodCast() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
