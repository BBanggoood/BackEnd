package com.bbanggood.springcontents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@AllArgsConstructor
public class VodCalenderDTO {
    private String vodId;
    private String vodName;
    private Date vodOpenAt;
    private String vodDirector;
    private String vodCast;
    private String vodPoster;
}
