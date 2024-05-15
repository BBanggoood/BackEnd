package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.projection.VodIdProjection;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VodSearchService {

    @Autowired
    private VodRepository vodRepository;

    public List<VodIdProjection> searchVodsByName(String name) {
        return vodRepository.findByVodNameLike(name);
    }
}