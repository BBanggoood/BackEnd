package com.bbanggood.springbbanglist.repository;

import com.bbanggood.springbbanglist.entity.BBangCast;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BBangCastRepository extends MongoRepository<BBangCast, Integer> {
    List<BBangCast> findAllBySetbxId(String setbxId);
}
