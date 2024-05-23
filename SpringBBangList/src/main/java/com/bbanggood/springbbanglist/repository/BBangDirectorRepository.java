package com.bbanggood.springbbanglist.repository;

import com.bbanggood.springbbanglist.entity.BBangDirector;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BBangDirectorRepository extends MongoRepository<BBangDirector, Integer> {
    List<BBangDirector> findAllBySetbxId(Integer setbxId);
}
