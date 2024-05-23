package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BBangVodRepository extends JpaRepository<BBangVod, BBangVodId> {
}
