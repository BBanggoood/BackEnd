package com.bbanggood.springsignup.controller;

import com.bbanggood.springsignup.entity.UserCreateForm;
import com.bbanggood.springsignup.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
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
            return bindingResult.getAllErrors().toString();
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
}