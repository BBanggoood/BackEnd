package com.bbanggood.springviewrecord.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage {
    private String setbxId;

    private Integer vodId;

    private Integer watchTime;

    private Instant startTime;

    private Instant endTime;
}
