package com.bbanggood.springbbangupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bbanggood.springbbangupdate.entity.UserMysql;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMysql, Integer> {
}
