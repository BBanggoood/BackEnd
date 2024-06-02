package com.bbanggood.springbbangupdate.controller;

import com.bbanggood.springbbangupdate.DTO.BBangDirectorDTO;
import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.service.BBangDirectorService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("bbang")
public class BBangDirectorController {
    private final BBangDirectorService bbangDirectorService;

    @PostMapping("/director")
    public ResponseEntity<BBangDirector> addDirector(@RequestBody BBangDirectorDTO bbangDirectorDTO) {
        BBangDirector bbangDirector = bbangDirectorService.AddDirector(bbangDirectorDTO.getSetbxId(),
                bbangDirectorDTO.getVodDirector(), bbangDirectorDTO.getVodDirectorPoster());
        return ResponseEntity.ok(bbangDirector);
    }

    @DeleteMapping("/director")
    public ResponseEntity<String> deleteDirector(@RequestBody BBangDirectorDTO bbangDirectorDTO) {
        try {
            bbangDirectorService.DeleteDirector(bbangDirectorDTO.getSetbxId(), bbangDirectorDTO.getVodDirector());
            return ResponseEntity.ok().body("User " + bbangDirectorDTO.getSetbxId() + " with vodDirector " + bbangDirectorDTO.getVodDirector() + " has been successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
