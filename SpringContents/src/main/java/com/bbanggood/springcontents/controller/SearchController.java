package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.projection.VodIdProjection;
import com.bbanggood.springcontents.service.VodSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class SearchController {

    private final VodSearchService vodSearchService;

    @Autowired
    public SearchController(VodSearchService vodSearchService) {
        this.vodSearchService = vodSearchService;
    }

    @GetMapping("/search/{name}")
    public List<VodIdProjection> searchVodByName(@PathVariable String name) {
        return vodSearchService.searchVodsByName(name);
    }
}