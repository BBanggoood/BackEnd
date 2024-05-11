package com.bbanggood.springsignup.service;

import com.bbanggood.springsignup.entity.UserMysql;
import com.bbanggood.springsignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMysql create(String username, String password, String name,
                            String phone, String birth,/*LocalDate birth, */String sex) {
        UserMysql user = new UserMysql();
        user.setUserEmail(username);
        user.setUserPwd(passwordEncoder.encode(password));
        user.setUserName(name);
        user.setUserPhone(phone);
        user.setUserBirth(birth);
        user.setUserSex(sex);

        this.userRepository.save(user);
        return user;
    }

    @GetMapping
    public List<UserMysql> GetAllUsers() {
        return userRepository.findAll();
    }
}