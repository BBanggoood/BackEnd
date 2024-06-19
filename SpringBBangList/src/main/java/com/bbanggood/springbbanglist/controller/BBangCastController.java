package com.bbanggood.springbbanglist.controller;

import com.bbanggood.springbbanglist.service.BBangCastService;
import com.bbanggood.springbbanglist.entity.BBangCast;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bbang")
@RequiredArgsConstructor
public class BBangCastController {
    private final BBangCastService bbangCastService;

    @GetMapping("/cast/{setbxId}")
    public List<BBangCast> GetBBangCastList(@PathVariable String setbxId) {
        return bbangCastService.BBangCastList(setbxId);
    }
}
