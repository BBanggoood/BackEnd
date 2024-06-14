package com.bbanggood.springrecommend.entity;

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
    private ObjectId id;

    @Field("VOD_ID")
    private String vodId;
    @Field("VOD_NAME")
    private String vodName;
    @Field("VOD_POSTER")
    private String vodPoster;
    @Field("VOD_CATEGORY")
    private String vodCategory;
    @Field("VOD_GENRE")
    private String vodGenre;
    @Field("VOD_KEYWORD")
    private String vodKeyword;
    @Field("VOD_SUMMARY")
    private String vodSummary;
    @Field("VOD_SUMMARY_TOKEN")
    private String vodSummaryToken;
    @Field("VOD_CAST")
    private String vodCast;
    @Field("VOD_CAST_POSTER")
    private String vodCastPoster;
    @Field("VOD_DIRECTOR")
    private String vodDirector;
    @Field("VOD_DIRECTOR_POSTER")
    private String vodDirectorPoster;
    @Field("VOD_OPEN_AT")
    private Date vodOpenAt;
    @Field("VOD_UPDATED_AT")
    private Date vodUpdatedAt;
    @Field("VOD_PRICE")
    private Integer vodPrice;
    @Field("VOD_TIME")
    private Integer vodTime;
    @Field("VOD_COUNT")
    private Integer vodCount;
    @Field("VOD_RATING")
    private Float vodRating;
}
