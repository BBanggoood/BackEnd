package com.bbanggood.springrecommend.repository;

import com.bbanggood.springrecommend.entity.RecommendEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecommendRepository extends MongoRepository<RecommendEntity, ObjectId> {
    RecommendEntity findBySetbxId(String setbxId);
}
