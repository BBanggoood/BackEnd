package com.bbanggood.springbbangupdate.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBangDirectorMessage {
    private String setbxId;
    private String vodDirector;
    private String vodDirectorPoster;
}
