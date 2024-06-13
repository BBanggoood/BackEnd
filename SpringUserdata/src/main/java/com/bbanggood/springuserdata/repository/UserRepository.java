package com.bbanggood.springuserdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<com.bbanggood.springuserdata.entity.UserEntity, String> {
    Optional<com.bbanggood.springuserdata.entity.UserEntity> findBySetbxId(String setbxId);
}