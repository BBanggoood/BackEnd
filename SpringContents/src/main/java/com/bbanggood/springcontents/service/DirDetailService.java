package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class DirDetailService {

    @Autowired
    private VodRepository vodRepository;

    public List<VodEntity> getVodByVodDirector(String vodDirector, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        return vodRepository.findByVodDirectorLike(vodDirector, sort);
    }
}
