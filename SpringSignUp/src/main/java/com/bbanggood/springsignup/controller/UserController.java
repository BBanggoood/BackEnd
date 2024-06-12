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
                userSignUpDTO.getUserSex(), userSignUpDTO.getUserBirth(),
                userSignUpDTO.getUserAdult(), userSignUpDTO.getUserAdultKey(),
                userSignUpDTO.getUserLikeGenre(), userSignUpDTO.getUserLikeVod(),
                userSignUpDTO.getUserRole(), userSignUpDTO.getUserCreatedAt(),
                userSignUpDTO.getUserUpdatedAt());

        // 카프카 연동
        chatmessage.setUserSetbxId(userSignUpDTO.getUserSetbxId().toString());
        chatmessage.setUserEmail(userSignUpDTO.getUserEmail());
        chatmessage.setUserPwd(userSignUpDTO.getUserPwd());
        chatmessage.setUserName(userSignUpDTO.getUserName());
        chatmessage.setUserPhone(userSignUpDTO.getUserPhone());
        chatmessage.setUserSex(userSignUpDTO.getUserSex());
        chatmessage.setUserBirth(userSignUpDTO.getUserBirth());

        chatmessage.setUserAdult(userSignUpDTO.getUserAdult());
        chatmessage.setUserAdultKey(userSignUpDTO.getUserAdultKey());
        chatmessage.setUserLikeGenre(userSignUpDTO.getUserLikeGenre());
        chatmessage.setUserLikeVod(userSignUpDTO.getUserLikeVod());
        chatmessage.setUserRole(userSignUpDTO.getUserRole());
        chatmessage.setUserCreatedAt(userSignUpDTO.getUserCreatedAt());
        chatmessage.setUserUpdatedAt(userSignUpDTO.getUserUpdatedAt());

        producerService.sendSignUpMessage(chatmessage);

        return "회원 가입 성공!!";
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody UserSignUpDTO userSignUpDTO, ChatMessage chatmessage) {
        try {
            userService.UserWithdraw(userSignUpDTO.getUserSetbxId());

            // 카프카 연동
            chatmessage.setUserSetbxId(userSignUpDTO.getUserSetbxId().toString());
            producerService.sendWithdrawMessage(chatmessage);

            return ResponseEntity.ok().body("User with setbxId " + userSignUpDTO.getUserSetbxId() + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateuserdata(@RequestBody UserSignUpDTO userSignUpDTO, ChatMessage chatmessage) {
        try {
            userService.UpdateUserData(userSignUpDTO.getUserSetbxId(), userSignUpDTO.getUserPwd(), userSignUpDTO.getConfirmUserPwd(),
                    userSignUpDTO.getUserName(), userSignUpDTO.getUserSex(), userSignUpDTO.getUserBirth(),
                    userSignUpDTO.getUserAdult(), userSignUpDTO.getUserAdultKey(), userSignUpDTO.getUserLikeGenre(),
                    userSignUpDTO.getUserLikeVod(), userSignUpDTO.getUserRole(), userSignUpDTO.getUserCreatedAt(), userSignUpDTO.getUserUpdatedAt());

            // 카프카 연동
            chatmessage.setUserSetbxId(userSignUpDTO.getUserSetbxId().toString());
            chatmessage.setUserPwd(userSignUpDTO.getUserPwd());
            chatmessage.setUserName(userSignUpDTO.getUserName());
            chatmessage.setUserSex(userSignUpDTO.getUserSex());
            chatmessage.setUserBirth(userSignUpDTO.getUserBirth());

            chatmessage.setUserAdult(userSignUpDTO.getUserAdult());
            chatmessage.setUserAdultKey(userSignUpDTO.getUserAdultKey());
            chatmessage.setUserLikeGenre(userSignUpDTO.getUserLikeGenre());
            chatmessage.setUserLikeVod(userSignUpDTO.getUserLikeVod());
            chatmessage.setUserRole(userSignUpDTO.getUserRole());
            chatmessage.setUserCreatedAt(userSignUpDTO.getUserCreatedAt());
            chatmessage.setUserUpdatedAt(userSignUpDTO.getUserUpdatedAt());

            producerService.sendUpdateMessage(chatmessage);

            return ResponseEntity.ok().body("User with setbxId " + userSignUpDTO.getUserSetbxId() +  " has been successfully changed.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}