package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangDirectorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/director")
    public ResponseEntity<String> deleteVod(@RequestBody BBangDirectorId bbangDirectorId) {
        try {
            bbangDirectorService.DeleteDirector(bbangDirectorId.getSetbxId(), bbangDirectorId.getVodDirector());
            return ResponseEntity.ok().body("User with setbxId " + bbangDirectorId.getSetbxId() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
