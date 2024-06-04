package com.bbanggood.login.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "user")
@Data
public class UserEntity {

    @Id
    private ObjectId id;

    @Field("SETBX_ID")
    private Integer username;
    @Field("USER_PWD")
    private String password;
    @Field("USER_ROLE")
    private String role;

    @Field("USER_BIRTH")
    private String birth;
    @Field("USER_NAME")
    private String name;
    @Field("USER_SEX")
    private String gender;
    @Field("USER_PHONE")
    private String phone;

    private String USER_CREATED_AT;
}