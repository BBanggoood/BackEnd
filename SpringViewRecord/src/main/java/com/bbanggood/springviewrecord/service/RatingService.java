package com.bbanggood.springviewrecord.service;

import com.bbanggood.springviewrecord.entity.Rating;
import com.bbanggood.springviewrecord.respository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public void RatingPost(Integer setbxId, Integer vodId, BigDecimal rating) {
        Rating rate = new Rating();

        rate.setSetbxId(setbxId);
        rate.setVodId(vodId);
        rate.setRating(rating);

        ratingRepository.save(rate);
    }
}
