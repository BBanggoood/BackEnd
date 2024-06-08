package com.bbanggood.springviewrecord.respository;

import com.bbanggood.springviewrecord.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickRepository extends JpaRepository<Click, Integer> {
}
