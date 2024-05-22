package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.dto.DirDetailDto;
import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.service.DirDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contents")
public class DirDetailController {

    private final DirDetailService dirDetailService;

    @Autowired
    public DirDetailController(DirDetailService dirDetailService) {
        this.dirDetailService = dirDetailService;
    }

    @GetMapping("/detail/director/{vodDirector}")
    public List<DirDetailDto> getVodDetailsByDirector(@PathVariable String vodDirector) {
        List<VodEntity> vodEntities = dirDetailService.getVodByVodDirector(vodDirector);
        return vodEntities.stream()
                .map(vod -> new DirDetailDto(
                        vod.getVodDirector(),
                        vod.getVodCastPoster(),
                        vod.getVodId().toHexString(),
                        vod.getVodPoster(),
                        vod.getVodName()))
                .collect(Collectors.toList());
    }
}
