package com.bbanggood.springsignup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "USER_EMAIL", nullable = false, length = 254)
    private String userEmail;

    @Column(name = "USER_PWD", nullable = false)
    private String userPwd;

    @Column(name = "USER_NAME", nullable = false, length = 30)
    private String userName;

    @Column(name = "USER_PHONE", nullable = false, length = 15)
    private String userPhone;

    @Column(name = "USER_BIRTH", nullable = false)
    private LocalDate userBirth;

    @Column(name = "USER_SEX", nullable = false)
    private Character userSex;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "USER_CREATED_AT", nullable = false)
    private Instant userCreatedAt;

}