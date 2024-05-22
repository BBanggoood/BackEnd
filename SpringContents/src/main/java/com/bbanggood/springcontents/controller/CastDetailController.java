package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.dto.CastDetailDto;
import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.service.CastDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contents")
public class CastDetailController {

    private final CastDetailService castDetailService;

    @Autowired
    public CastDetailController(CastDetailService castDetailService) {
        this.castDetailService = castDetailService;
    }

    @GetMapping("/detail/cast/{vodCast}")
    public List<CastDetailDto> getVodDetailsByCast(@PathVariable String vodCast) {
        List<VodEntity> vodEntities = castDetailService.getVodByVodCast(vodCast);
        return vodEntities.stream()
                .map(vod -> new CastDetailDto(
                        vod.getVodCast(),
                        vod.getVodCastPoster(),
                        vod.getVodId().toHexString(),
                        vod.getVodPoster(),
                        vod.getVodName()))
                .collect(Collectors.toList());
    }
}