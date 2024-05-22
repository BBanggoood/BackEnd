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
    private ObjectId vodId;

    // MySQL에서 작성한 VOD ID
    @Field("VOD_ID")
    private Long vodSqlId;


    // 상위 10개를 선정하기 위해서 이름 변경
    @Field("VOD_CLASSIFY")
    private String vodClassify;
    @Field("VOD_COUNT")
    private Long vodCount;


    // vod 상세 데이터를 출력하기 위해서 이름 변경
    @Field("VOD_NAME") // VOD명
    private String vodName;
    @Field("VOD_POSTER") // VOD 포스터
    private String vodPoster;
    @Field("VOD_SUMMARY") // VOD 줄거리
    private String vodSummary;

    @Field("VOD_DIRECTOR") // 감독명
    private String vodDirector;
    @Field("VOD_DIRECTOR_POSTER") // 감독 포스터
    private String vodDirectorPoster;

    @Field("VOD_CAST") // 출연진
    private String vodCast;
    @Field("VOD_CAST_POSTER") // 출연진 포스터
    private String vodCastPoster;

    @Field("VOD_PRICE") // 가격
    private Long vodPrice;


    private String VOD_GENRE;
    private String VOD_INITIAL;
    private String VOD_KEYWORD;
    private String VOD_TIME;
    private Date VOD_OPEN_AT;
    private Date VOD_UPDATED_AT;
}