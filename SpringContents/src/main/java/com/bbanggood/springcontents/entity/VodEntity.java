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

    // 상위 10개를 선정하기 위해서 이름 변경
    @Field("VOD_CLASSIFY")
    private String vodClassify;
    @Field("VOD_COUNT")
    private Long vodCount;

    // vod 상세 데이터를 출력하기 위해서 이름 변경
    @Field("VOD_NAME") // 제목
    private String vodName;
    @Field("VOD_DIRECTOR") // 감독
    private String vodDirector;
    @Field("VOD_CAST") // 출연진
    private String vodCast;
    @Field("VOD_SUMMARY") // 줄거리
    private String vodSummary;
    @Field("VOD_POSTER") // 포스터
    private String vodPoster;

    private String VOD_CAST_POSTER;
    private String VOD_DIRECTOR_POSTER;
    private String VOD_GENRE;
    private String VOD_INITIAL;
    private String VOD_KEYWORD;
    private String VOD_TIME;
    private Date VOD_OPEN_AT;
    private Date VOD_UPDATED_AT;
    private Long VOD_PRICE;
}