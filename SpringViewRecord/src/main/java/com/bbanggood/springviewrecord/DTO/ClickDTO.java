package com.bbanggood.springviewrecord.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ClickDTO {
    private Integer setbxId;

    private Integer vodId;

    private String viewType;

    private Instant clickTime;
}
