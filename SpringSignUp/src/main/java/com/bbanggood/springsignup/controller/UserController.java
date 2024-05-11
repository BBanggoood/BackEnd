package com.bbanggood.springsignup.controller;

import com.bbanggood.springsignup.entity.UserCreateForm;
import com.bbanggood.springsignup.entity.UserMysql;
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

//    @GetMapping("/signup")
//    public String signup() {
//        return "signup_form";
//    }

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return "signup_form";
            return "오류";
//            return bindingResult.getAllErrors().toString();
        }

        if (!userCreateForm.getUserPwd().equals(userCreateForm.getConfirmUserPwd())) {
            bindingResult.rejectValue("confirmUserPwd", "confirmUserPwd.invalid",
                    "2개의 비밀번호가 일치하지 않습니다.");
//            return "signup_form";
            return bindingResult.getAllErrors().toString();
        }

        userService.create(userCreateForm.getUserEmail(), userCreateForm.getUserPwd(),
                userCreateForm.getUserName(), userCreateForm.getUserPhone(),
                userCreateForm.getUserBirth(), userCreateForm.getUserSex());

//        return "redirect:/";
        return "회원 가입 성공!!";
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody UserMysql userMysql) {
        try {
            userService.delete(userMysql.getUserEmail());
            return ResponseEntity.ok().body("User with email " + userMysql.getUserEmail() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }

    @PatchMapping("/update/password")
    public ResponseEntity<String> updatepassword(@RequestBody UserMysql userMysql) {
        try {
            userService.update_password(userMysql.getUserEmail(), userMysql.getUserPwd(), userMysql.getConfirmUserPwd());
            return ResponseEntity.ok().body("User password has been successfully changed.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }

    @PatchMapping("/update/userdata")
    public ResponseEntity<String> updateuserdata(@RequestBody UserMysql userMysql) {
        try {
            userService.update_userdata(userMysql.getUserEmail(), userMysql.getUserBirth(), userMysql.getUserSex());
            return ResponseEntity.ok().body("User data has been successfully changed.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}