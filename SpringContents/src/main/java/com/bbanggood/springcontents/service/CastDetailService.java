package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class CastDetailService {

    @Autowired
    private VodRepository vodRepository;

    public List<VodEntity> getVodByVodCast(String vodCast, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        return vodRepository.findByVodCastLike(vodCast, sort);
    }
}
