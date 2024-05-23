//package com.bbanggood.springsignup.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "user_mysql")
//public class UserMysql {
//    @Id
//    @Column(name = "USER_EMAIL", nullable = false, length = 254)
//    private String userEmail;
//
//    @Column(name = "USER_PWD", nullable = false)
//    private String userPwd;
//
//    private String confirmUserPwd;
//
//    @Column(name = "USER_NAME", nullable = false, length = 30)
//    private String userName;
//
//    @Column(name = "USER_PHONE", nullable = false, length = 15)
//    private String userPhone;
//
//    @Column(name = "USER_BIRTH", nullable = false)
////    private LocalDate userBirth;
//    private String userBirth;
//
//    @Column(name = "USER_SEX", nullable = false)
//    private String userSex;
//}