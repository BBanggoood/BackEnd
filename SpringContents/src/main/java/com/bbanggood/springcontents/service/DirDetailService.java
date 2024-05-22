package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirDetailService {

    @Autowired
    private VodRepository vodRepository;

    public List<VodEntity> getVodByVodDirector(String vodDirector) {
        return vodRepository.findByVodDirectorLike(vodDirector);
    }
}
