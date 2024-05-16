package com.bbanggood.springcontents.dto;

import lombok.Data;

@Data
public class VodDetailDto {

    private String vodName;
    private String vodDirector;
    private String vodCast;
    private String vodSummary;
    private String vodPoster;

    // No-argument constructor
    public VodDetailDto() {
    }

    // All-argument constructor
    public VodDetailDto(String vodName, String vodDirector, String vodCast, String vodSummary, String vodPoster) {
        this.vodName = vodName;
        this.vodDirector = vodDirector;
        this.vodCast = vodCast;
        this.vodSummary = vodSummary;
        this.vodPoster = vodPoster;
    }
}