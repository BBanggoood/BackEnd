package com.bbanggood.springviewrecord.respository;

import com.bbanggood.springviewrecord.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}
