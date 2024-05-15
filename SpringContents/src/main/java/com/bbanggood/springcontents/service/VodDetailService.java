package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VodDetailService {

    @Autowired
    private VodRepository vodRepository;

    public Optional<VodEntity> getVodById(String vodId) {
        return vodRepository.findByVodId(vodId);
    }
}