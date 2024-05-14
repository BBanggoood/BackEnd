package com.bbanggood.springsignup.repository;

import com.bbanggood.springsignup.entity.UserMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMysql, String> {
}
