package com.bbanggood.springbbanglist.repository;

import com.bbanggood.springbbanglist.entity.BBangVod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BBangVodRepository extends MongoRepository<BBangVod, Integer> {
    List<BBangVod> findAllBySetbxId(Integer setbxId);
}
