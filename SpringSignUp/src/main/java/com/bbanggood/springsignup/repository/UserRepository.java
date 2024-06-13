package com.bbanggood.springsignup.repository;

import com.bbanggood.springsignup.entity.MysqlUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MysqlUser, String> {
    MysqlUser findByUserSetbxId(Integer userSetbxId);
}
