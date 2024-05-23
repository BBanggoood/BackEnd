package com.bbanggood.springbbangupdate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user_mysql")
public class UserMysql {
    @Id
    @Column(name = "SETBX_ID", nullable = false)
    private Integer setbxId;

    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail;

    @Column(name = "USER_PWD", nullable = false)
    private String userPwd;

    @Column(name = "USER_NAME", nullable = false, length = 100)
    private String userName;

    @Column(name = "USER_PHONE", nullable = false, length = 20)
    private String userPhone;

    @Lob
    @Column(name = "USER_SEX", nullable = false)
    private String userSex;

    @Column(name = "USER_BIRTH", nullable = false)
    private LocalDate userBirth;

    @ColumnDefault("0")
    @Column(name = "USER_AUTH")
    private Boolean userAuth;

    @Column(name = "USER_AUTH_KEY", length = 4)
    private String userAuthKey;

    @Column(name = "USER_LIKE_GENRE")
    private String userLikeGenre;

    @Column(name = "USER_LIKE_VOD", length = 511)
    private String userLikeVod;

    @ColumnDefault("ROLE_ADMIN")
    @Lob
    @Column(name = "USER_ROLE")
    private String userRole;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "USER_CREATED_AT")
    private Instant userCreatedAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "USER_UPDATED_AT")
    private Instant userUpdatedAt;

}