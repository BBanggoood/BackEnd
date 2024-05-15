package com.bbanggood.springcontents.controller.TopController;

import com.bbanggood.springcontents.projection.VodIdProjection;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/contents/kids")
public class TopKids {

    private final VodRepository VodRepository;
    public TopKids(VodRepository VodRepository) {
        this.VodRepository = VodRepository;
    }

    @GetMapping("/top")
    public List<VodIdProjection> getTopKidsMovies() {
        return VodRepository.findTop10ByVodClassifyInOrderByVodCountDesc(Arrays.asList("키즈"));
    }
}