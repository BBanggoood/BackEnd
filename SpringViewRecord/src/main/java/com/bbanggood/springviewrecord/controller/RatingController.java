package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.RatingDTO;
import com.bbanggood.springviewrecord.kafka.RatingMessage;
import com.bbanggood.springviewrecord.service.RatingService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bbanggood.springviewrecord.kafka.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RestController
@RequestMapping("/view-record")
public class RatingController {
    private final RatingService ratingService;
    private final KafkaProducerService producerService;

    @PostMapping("/rating")
    public String AddRatingRecord(@RequestBody RatingDTO rating, BindingResult bindingResult, RatingMessage ratingMessage) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        // 카프카 연동
        ratingMessage.setSetbxId(rating.getSetbxId().toString());
        ratingMessage.setVodId(rating.getVodId());
        ratingMessage.setRating(rating.getRating());
        producerService.sendRatingMessage(ratingMessage);
        
        ratingService.RatingPost(rating.getSetbxId(), rating.getVodId(), rating.getRating());
        
        return "평점 입력 완료";
    }
}
