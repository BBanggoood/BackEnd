package com.bbanggood.springsignup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMysql, String> {
}
