package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/main")
public class TopMain {

    private final VodRepository VodRepository;
    public TopMain(VodRepository VodRepository) {
        this.VodRepository = VodRepository;
    }

    @GetMapping("/top")
    public List<VodEntity> getTopKidsMovies() {
        return VodRepository.findTop10ByVodClassifyInOrderByVodCountDesc(Arrays.asList("영화", "드라마", "애니메이션", "연예/오락", "키즈", "교육", "다큐", "스포츠"));
    }
}