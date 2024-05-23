package com.bbanggood.springsignup.controller;

import com.bbanggood.springsignup.DTO.UserSignUpDTO;
import com.bbanggood.springsignup.entity.MysqlUser;
import com.bbanggood.springsignup.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody UserSignUpDTO userSignUpDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return "signup_form";
            return "오류";
//            return bindingResult.getAllErrors().toString();
        }

        if (!userSignUpDTO.getUserPwd().equals(userSignUpDTO.getConfirmUserPwd())) {
            bindingResult.rejectValue("confirmUserPwd", "confirmUserPwd.invalid",
                    "2개의 비밀번호가 일치하지 않습니다.");
//            return "signup_form";
            return bindingResult.getAllErrors().toString();
        }

        userService.UserSignUp(userSignUpDTO.getUserSetbxId(), userSignUpDTO.getUserEmail(), userSignUpDTO.getUserPwd(),
                userSignUpDTO.getUserName(), userSignUpDTO.getUserPhone(),
                userSignUpDTO.getUserSex(), userSignUpDTO.getUserBirth());

//        return "redirect:/";
        return "회원 가입 성공!!";
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody MysqlUser mysqlUser) {
        try {
            userService.UserWithdraw(mysqlUser.getSetbxId());
            return ResponseEntity.ok().body("User with email " + mysqlUser.getUserEmail() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }

    @PatchMapping("/update/userdata")
    public ResponseEntity<String> updateuserdata(@RequestBody MysqlUser mysqlUser) {
        try {
            userService.UpdateUserData(mysqlUser.getSetbxId(), mysqlUser.getUserPwd(), mysqlUser.getConfirmUserPwd(),
                    mysqlUser.getUserName(), mysqlUser.getUserBirth(), mysqlUser.getUserSex());
            return ResponseEntity.ok().body("User data has been successfully changed.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}