package com.bbanggood.springsignup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
public class MysqlUser {
    @Id
    @Column(name = "SETBX_ID", nullable = false)
    private Integer userSetbxId;

    @Size(max = 255)
    @NotNull
    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail;

    @Size(max = 255)
    @NotNull
    @Column(name = "USER_PWD", nullable = false)
    private String userPwd;

//    private String confirmUserPwd;

    @Size(max = 100)
    @NotNull
    @Column(name = "USER_NAME", nullable = false, length = 100)
    private String userName;

    @Size(max = 20)
    @NotNull
    @Column(name = "USER_PHONE", nullable = false, length = 20)
    private String userPhone;

    @NotNull
    @Lob
    @Column(name = "USER_SEX", nullable = false)
    private String userSex;

    @NotNull
    @Column(name = "USER_BIRTH", nullable = false)
    private LocalDate userBirth;

    @ColumnDefault("0")
    @Column(name = "USER_ADULT")
    private Boolean userAdult;

    @Size(max = 4)
    @Column(name = "USER_ADULT_KEY", length = 4)
    private String userAdultKey;

    @Size(max = 255)
    @Column(name = "USER_LIKE_GENRE")
    private String userLikeGenre;

    @Size(max = 255)
    @Column(name = "USER_LIKE_VOD")
    private String userLikeVod;

    @ColumnDefault("ROLE_ADMIN")
    @Lob
    @Column(name = "USER_ROLE")
    private String userRole;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @CreationTimestamp
    @Column(name = "USER_CREATED_AT")
    private Instant userCreatedAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Column(name = "USER_UPDATED_AT")
    private Instant userUpdatedAt;

}