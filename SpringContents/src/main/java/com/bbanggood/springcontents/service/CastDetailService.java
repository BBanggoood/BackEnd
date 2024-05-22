package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastDetailService {

    @Autowired
    private VodRepository vodRepository;

    public List<VodEntity> getVodByVodCast(String vodCast) {
        return vodRepository.findByVodCastLike(vodCast);
    }
}
