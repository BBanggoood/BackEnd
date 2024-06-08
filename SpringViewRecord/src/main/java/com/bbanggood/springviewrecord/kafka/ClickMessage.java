package com.bbanggood.springviewrecord.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClickMessage {
    private String setbxId;

    private Integer vodId;

    private String viewType;

    private Instant clickTime;
}
