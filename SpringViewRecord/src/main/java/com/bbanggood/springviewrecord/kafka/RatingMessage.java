package com.bbanggood.springviewrecord.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingMessage {
    private String setbxId;

    private String vodName;

    private String rating;
}
