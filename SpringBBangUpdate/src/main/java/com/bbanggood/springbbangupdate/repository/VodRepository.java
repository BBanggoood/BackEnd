package com.bbanggood.springbbangupdate.repository;

import com.bbanggood.springbbangupdate.entity.Vod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VodRepository extends JpaRepository<Vod, Integer> {
    Vod findByVodCast(String vodCast);
    Vod findByVodDirector(String vodDirector);
}
