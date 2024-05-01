package com.bbanggood.login.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "user_mongodb")
@Data
public class UserEntity {

    @Id
    private ObjectId id;

    @Field("USER_EMAIL")
    private String username;
    @Field("USER_PWD")
    private String password;
    @Field("USER_ROLE")
    private String role;

    private Date USER_BIRTH;
    private String USER_CREATED_AT;
    private String USER_NAME;
    private Long USER_PHONE;
    private String USER_SEX;
}