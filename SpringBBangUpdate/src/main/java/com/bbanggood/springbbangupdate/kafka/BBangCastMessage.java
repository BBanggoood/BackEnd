package com.bbanggood.springbbangupdate.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BBangCastMessage {
    private String setbxId;
    private String vodCast;
    private String vodCastPoster;
}
