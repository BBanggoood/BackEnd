//package com.bbanggood.springsignup.DTO;
//
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class UserCreateForm {
//    @Size(min = 3, max = 25)
//    @NotEmpty(message = "사용자 이메일은 필수 항목입니다.")
//    private String userEmail;
//
//    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
//    private String userPwd;
//
//    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
//    private String confirmUserPwd;
//
//    @NotEmpty(message = "사용자 이름은 필수 항목입니다.")
//    private String userName;
//
//    @NotEmpty(message = "핸드폰 번호는 필수 항목입니다.")
//    private String userPhone;
//
//    @NotEmpty(message = "사용자 생년월일은 필수 항목입니다.")
////    private LocalDate userBirth;
//    private String userBirth;
//
//    @NotEmpty(message = "사용자 성별은 필수 항목입니다.")
//    private String userSex;
//}
