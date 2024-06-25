package com.bbanggood.springcontents.repository;

import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.projection.VodIdProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VodRepository extends MongoRepository<VodEntity, String> {
    List<VodIdProjection> findTop10ByVodClassifyInOrderByVodCountDesc(List<String> vodClassify);

    @Query("{'vodName': {$regex: ?0, $options: 'i'}}") // i는 대소문자 구분 없이 검색
    List<VodIdProjection> findByVodNameLike(String vodName);

    Optional<VodEntity> findByVodId(String vodId);

    @Query("{'vodDirector': {$regex: ?0, $options: 'i'}}") // i는 대소문자 구분 없이 검색
    List<VodEntity> findByVodDirectorLike(String vodDirector, Sort sort);

    @Query("{'vodCast': {$regex: ?0, $options: 'i'}}") // i는 대소문자 구분 없이 검색
    List<VodEntity> findByVodCastLike(String vodCast, Sort sort);

    List<VodEntity> findByVodOpenAtBetween(Date start, Date end);
}
