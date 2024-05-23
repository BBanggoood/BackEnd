package com.bbanggood.springbbanglist.controller;

import com.bbanggood.springbbanglist.service.BBangVodService;
import com.bbanggood.springbbanglist.entity.BBangVod;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bbang")
@RequiredArgsConstructor
public class BBangVodController {
    private final BBangVodService bbangVodService;

    @GetMapping("/vod/{setbxId}")
    public List<BBangVod> GetBBangVodList(@PathVariable Integer setbxId) {
        return bbangVodService.BBangVodList(setbxId);
    }
}
