package com.bbanggood.springrecommend.entity;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "recommend")
@Data
public class RecommendEntity {

    @Id
    private ObjectId id;

    @Field("RECOMMEND_ID")
    private String recommendId;
    @Field("SETBX_ID")
    private String setbxId;
    @Field("VOD_NAME")
    private String vodNameList;
    @Field("VOD_POSTER_URL")
    private String posterUrl;
}
