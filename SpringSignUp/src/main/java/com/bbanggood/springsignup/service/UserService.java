package com.bbanggood.springsignup.service;

import com.bbanggood.springsignup.entity.UserMysql;
import com.bbanggood.springsignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String email, String password, String name,
                       String phone, String birth,/*LocalDate birth, */String sex) {
        UserMysql user = new UserMysql();
        user.setUserEmail(email);
        user.setUserPwd(passwordEncoder.encode(password));
        user.setUserName(name);
        user.setUserPhone(phone);
        user.setUserBirth(birth);
        user.setUserSex(sex);

        this.userRepository.save(user);
    }

    public void delete(String userEmail) {
        Optional<UserMysql> userOptional = userRepository.findById(userEmail);

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            UserMysql user = userOptional.get();
            userRepository.delete(user);
        } else {
            System.out.println("No user found with email: " + userEmail);
            throw new RuntimeException("No user found with email: " + userEmail);
        }
    }

    public void update_password(String userEmail, String newPassword, String confirmPassword) {
        Optional<UserMysql> userOptional = userRepository.findById(userEmail);

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            UserMysql user = userOptional.get();

            user.setUserPwd(newPassword);
            user.setConfirmUserPwd(confirmPassword);

            if (newPassword.equals(confirmPassword)) {
                user.setUserPwd(passwordEncoder.encode(newPassword));
                this.userRepository.save(user);
            }
            else {
                throw new RuntimeException("Passwords do not match.");
            }
        } else {
            throw new RuntimeException("No user found with email: " + userEmail);
        }
    }

    public void update_userdata(String userEmail, String birth, String sex) {
        Optional<UserMysql> userOptional = userRepository.findById(userEmail);

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            UserMysql user = userOptional.get();

            user.setUserBirth(birth);
            user.setUserSex(sex);

            this.userRepository.save(user);
        } else {
            throw new RuntimeException("No user found with email: " + userEmail);
        }
    }
}