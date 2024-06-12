package com.bbanggood.springviewrecord.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClickMessage {
    private String setbxId;

    private String vodName;

    private String viewType;

    private LocalDate clickTime;
}
