package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangCastService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/cast")
    public ResponseEntity<String> deleteCast(@RequestBody BBangCastId bbangCastId) {
        try {
            bbangCastService.DeleteCast(bbangCastId.getSetbxId(), bbangCastId.getVodCast());
            return ResponseEntity.ok().body("User with setbxId " + bbangCastId.getSetbxId() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
