package com.bbanggood.springbbanglist.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "bbang_director")
public class BBangDirector {
    @Id
    private ObjectId bbangDirectorId;

    @Field("SETBX_ID")
    private String setbxId;

    @Field("VOD_DIRECTOR")
    private String vodDirector;

    @Field("VOD_DIRECTOR_POSTER")
    private String vodDirectorPoster;
}
