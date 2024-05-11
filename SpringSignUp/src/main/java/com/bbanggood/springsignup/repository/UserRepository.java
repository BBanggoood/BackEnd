package com.bbanggood.springsignup.repository;

import com.bbanggood.springsignup.entity.UserMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMysql, String> {
}
