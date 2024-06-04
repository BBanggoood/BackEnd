package com.bbanggood.springuserdata.controller;

import com.bbanggood.springuserdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userdata")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<com.bbanggood.springuserdata.entity.UserEntity> getUserData(@RequestParam("username") String username) {
        Optional<com.bbanggood.springuserdata.entity.UserEntity> userEntityOptional = userService.getUserByUsername(username);
        if (userEntityOptional.isPresent()) {
            com.bbanggood.springuserdata.entity.UserEntity userEntity = userEntityOptional.get();
            userEntity.setPassword(null);  // 패스워드를 응답에서 제외합니다.
            userEntity.setRole(null);      // 롤을 응답에서 제외합니다.
            return ResponseEntity.ok(userEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}