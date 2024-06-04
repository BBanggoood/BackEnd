package com.bbanggood.springsignup.controller;

import com.bbanggood.springsignup.DTO.UserSignUpDTO;
import com.bbanggood.springsignup.entity.MysqlUser;
import com.bbanggood.springsignup.kafka.ChatMessage;
import com.bbanggood.springsignup.kafka.KafkaProducerService;
import com.bbanggood.springsignup.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class UserController {
    private final UserService userService;
    private final KafkaProducerService producerService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody UserSignUpDTO userSignUpDTO, BindingResult bindingResult, ChatMessage chatmessage) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().toString();
        }

        if (!userSignUpDTO.getUserPwd().equals(userSignUpDTO.getConfirmUserPwd())) {
            bindingResult.rejectValue("confirmUserPwd", "confirmUserPwd.invalid",
                    "2개의 비밀번호가 일치하지 않습니다.");
            return bindingResult.getAllErrors().toString();
        }

        userService.UserSignUp(userSignUpDTO.getUserSetbxId(), userSignUpDTO.getUserEmail(), userSignUpDTO.getUserPwd(),
                userSignUpDTO.getUserName(), userSignUpDTO.getUserPhone(),
                userSignUpDTO.getUserSex(), userSignUpDTO.getUserBirth());

        // 카프카 연동
        chatmessage.setUserSetbxId(userSignUpDTO.getUserSetbxId());
        chatmessage.setUserEmail(userSignUpDTO.getUserEmail());
        chatmessage.setUserPwd(userSignUpDTO.getUserPwd());
        chatmessage.setUserName(userSignUpDTO.getUserName());
        chatmessage.setUserPhone(userSignUpDTO.getUserPhone());
        chatmessage.setUserSex(userSignUpDTO.getUserSex());
        chatmessage.setUserBirth(userSignUpDTO.getUserBirth());

        producerService.sendMessage(chatmessage);
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