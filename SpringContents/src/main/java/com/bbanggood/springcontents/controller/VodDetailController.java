package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.dto.VodDetailDto;
import com.bbanggood.springcontents.service.VodDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class VodDetailController {

    private final VodDetailService vodDetailService;

    @Autowired
    public VodDetailController(VodDetailService vodDetailService) {
        this.vodDetailService = vodDetailService;
    }

    @GetMapping("/detail/vod/{vodId}")
    public ResponseEntity<VodDetailDto> getVodDetail(@PathVariable String vodId) {
        return vodDetailService.getVodById(vodId)
                .map(vodEntity -> new VodDetailDto(
                        vodEntity.getVodName(),
                        vodEntity.getVodDirector(),
                        vodEntity.getVodCast(),
                        vodEntity.getVodSummary(),
                        vodEntity.getVodPoster()
                ))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}