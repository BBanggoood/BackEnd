package com.bbanggood.springsignup.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String userSetbxId;
    private String userEmail;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userSex;
    private LocalDate userBirth;

    private Boolean userAdult;
    private String userAdultKey;
    private String userLikeGenre;
    private String userLikeVod;
    private String userRole;
    private Instant userCreatedAt;
    private Instant userUpdatedAt;
}