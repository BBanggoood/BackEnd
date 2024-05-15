package com.bbanggood.springcontents.entity;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "vod")
@Data
public class VodEntity {

    @Id
    private ObjectId VOD_ID;

    @Field("VOD_CLASSIFY")
    private String vodClassify;
    @Field("VOD_COUNT")
    private Long vodCount;

    private String VOD_CAST;
    private String VOD_CAST_POSTER;
    private String VOD_DIRECTOR;
    private String VOD_DIRECTOR_POSTER;
    private String VOD_GENRE;
    private String VOD_INITIAL;
    private String VOD_KEYWORD;
    private String VOD_NAME;
    private String VOD_POSTER;
    private String VOD_SUMMARY;
    private String VOD_TIME;
    private Date VOD_OPEN_AT;
    private Date VOD_UPDATED_AT;
    private Long VOD_PRICE;
}
