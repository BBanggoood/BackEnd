package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.BBangDirector;
import com.bbanggood.springbbangupdate.entity.BBangDirectorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BBangDirectorRepository extends JpaRepository<BBangDirector, BBangDirectorId> {
}
