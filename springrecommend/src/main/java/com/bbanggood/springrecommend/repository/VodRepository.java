package com.bbanggood.springrecommend.repository;

import com.bbanggood.springrecommend.entity.VodEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VodRepository extends MongoRepository<VodEntity, ObjectId> {
    VodEntity findByVodName(String vodName);
}
