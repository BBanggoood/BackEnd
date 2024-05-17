package com.bbanggood.springbbanglist.controller;

import com.bbanggood.springbbanglist.service.BBangDirectorService;
import com.bbanggood.springbbanglist.entity.BBangDirector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bbang")
@RequiredArgsConstructor
public class BBangDirectorController {
    private final BBangDirectorService bbangDirectorService;

    @GetMapping("/director/{setbxId}")
    public List<BBangDirector> GetBBangDirectorList(@PathVariable Integer setbxId) {
        return bbangDirectorService.BBangDirectorList(setbxId);
    }
}
