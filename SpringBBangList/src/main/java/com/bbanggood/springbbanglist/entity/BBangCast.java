package com.bbanggood.springbbanglist.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "like_cast")
public class BBangCast {
    @Id
    private ObjectId bbangVodId;

    @Field("SETBX_ID")
    private Integer setbxId;

    @Field("VOD_CAST")
    private String vodCast;
}
