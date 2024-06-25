package com.bbanggood.springbbanglist.repository;

import com.bbanggood.springbbanglist.entity.BBangVod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BBangVodRepository extends MongoRepository<BBangVod, String> {
    List<BBangVod> findAllBySetbxId(String setbxId);
}
