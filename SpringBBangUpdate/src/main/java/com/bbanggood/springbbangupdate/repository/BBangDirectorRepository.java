package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BBangDirectorRepository extends JpaRepository<BBangDirector, Integer> {
    Optional<BBangDirector> findBySetbxIdAndVodDirector(Integer setbxId, String vodDirector);
}
