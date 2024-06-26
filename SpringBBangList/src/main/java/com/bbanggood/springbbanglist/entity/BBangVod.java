package com.bbanggood.springbbanglist.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "bbang_vod")
public class BBangVod {
    @Id
    private ObjectId bbangVodId;

    @Field("SETBX_ID")
    private String setbxId;

    @Field("VOD_ID")
    private String vodId;

    @Field("VOD_POSTER")
    private String vodPoster;
}
