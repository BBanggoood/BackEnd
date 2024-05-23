package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangCast;
import com.bbanggood.springbbangupdate.entity.BBangCastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BBangCastRepository extends JpaRepository<BBangCast, BBangCastId> {
}
