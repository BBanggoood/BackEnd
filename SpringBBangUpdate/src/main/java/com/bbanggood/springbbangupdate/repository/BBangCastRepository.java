package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BBangCastRepository extends JpaRepository<BBangCast, Integer> {
    Optional<BBangCast> findBySetbxIdAndVodCast(Integer setbxId, String vodCast);
}
