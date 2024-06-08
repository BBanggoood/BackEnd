package com.bbanggood.springbbangupdate.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBangVodMessage {
    private String setbxId;
    private Integer vodId;
    private String vodPoster;
}
