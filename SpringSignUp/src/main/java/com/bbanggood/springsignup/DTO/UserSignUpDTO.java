package com.bbanggood.springsignup.DTO;

import jakarta.validation.constraints.NotEmpty;
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
public class UserSignUpDTO {
    @NotNull(message = "셋톱박스 아이디는 필수 항목입니다.")
    private Integer userSetbxId;

    @Size(min = 1, max = 50)
    @NotEmpty(message = "사용자 이메일은 필수 항목입니다.")
    private String userEmail;

    @Size(min = 1, max = 30)
    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String userPwd;

//    @Size(min = 1, max = 30)
//    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String confirmUserPwd;

    @Size(min = 1, max = 15)
    @NotEmpty(message = "사용자 이름은 필수 항목입니다.")
    private String userName;

    @Size(min = 5, max = 15)
    @NotEmpty(message = "핸드폰 번호는 필수 항목입니다.")
    private String userPhone;

    @Size(min = 1, max = 10)
    @NotEmpty(message = "사용자 성별은 필수 항목입니다.")
    private String userSex;

    @NotNull(message = "사용자 생년월일은 필수 항목입니다.")
    private LocalDate userBirth;

    private Boolean userAdult = false;

    private String userAdultKey = "0000";

    private String userLikeGenre;

    private String userLikeVod;

    private String userRole = "ROLE_ADMIN";

    private Instant userCreatedAt;

    private Instant userUpdatedAt;
}
