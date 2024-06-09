package com.bbanggood.springuserdata.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
@Data
public class UserEntity {

    @Id
    private ObjectId id;

    @Field("SETBX_ID")
    private String setbxId;
    @Field("USER_PWD")
    private String password;
    @Field("USER_ROLE")
    private String role;

    @Field("USER_NAME")
    private String username;
    @Field("USER_SEX")
    private String gender;
    @Field("USER_BIRTH")
    private String birth;
    @Field("USER_PHONE")
    private String phone;
    @Field("USER_EMAIL")
    private String email;

    private String USER_CREATED_AT;
}