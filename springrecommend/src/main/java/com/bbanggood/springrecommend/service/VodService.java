package com.bbanggood.springrecommend.service;

import com.bbanggood.springrecommend.entity.VodEntity;
import com.bbanggood.springrecommend.repository.VodRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VodService {

    @Autowired
    private VodRepository vodRepository;

    public ObjectId findVodIdByVodName(String vodName) {
        VodEntity vodEntity = vodRepository.findByVodName(vodName);
        if (vodEntity != null) {
            return vodEntity.getId();
        } else {
            return null;
        }
    }
}
