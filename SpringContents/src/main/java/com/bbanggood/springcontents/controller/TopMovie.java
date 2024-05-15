package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class TopMovie {

    private final com.bbanggood.springcontents.repository.VodRepository VodRepository;
    public TopMovie(VodRepository VodRepository) {
        this.VodRepository = VodRepository;
    }

    @GetMapping("/top")
    public List<VodEntity> getTopKidsMovies() {
        return VodRepository.findTop10ByVodClassifyInOrderByVodCountDesc(Arrays.asList("영화"));
    }
}