package com.bbanggood.springviewrecord.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class LogDTO {
    private Integer setbxId;

    private Integer vodId;

    private Integer watchTime;

    private Instant startTime;

    private Instant endTime;
}
