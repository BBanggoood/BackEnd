package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BBangVodRepository extends JpaRepository<BBangVod, Integer> {
    Optional<BBangVod> findBySetbxIdAndVodId(Integer setbxId, String vodId);
}
