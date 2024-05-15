package com.bbanggood.springcontents.repository;

import com.bbanggood.springcontents.entity.VodEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VodRepository extends MongoRepository<VodEntity, String> {
    List<VodEntity> findTop10ByVodClassifyInOrderByVodCountDesc(List<String> vodClassify);
}
