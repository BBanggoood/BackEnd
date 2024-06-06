package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.RatingDTO;
import com.bbanggood.springviewrecord.service.RatingService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/view-record")
public class RatingController {
    private final RatingService ratingService;
    
    @PostMapping("/rating")
    public String AddRatingRecord(@RequestBody RatingDTO rating, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        
        ratingService.RatingPost(rating.getSetbxId(), rating.getVodId(), rating.getRating());
        
        return "평점 입력 완료";
    }
}
