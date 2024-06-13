package com.bbanggood.springviewrecord.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RatingDTO {
    private Integer setbxId;

    private String vodName;

    private BigDecimal rating;
}
