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

    private String vodName;

    private String watchTime;

    private String startTime;

    private String endTime;
}
