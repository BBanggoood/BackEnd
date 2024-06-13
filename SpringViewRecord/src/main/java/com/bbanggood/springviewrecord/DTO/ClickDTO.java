package com.bbanggood.springviewrecord.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ClickDTO {
    private Integer setbxId;

    private String vodName;

    private String viewType;

    private LocalDateTime clickTime;
}
