package com.bbanggood.springsignup.service;

import com.bbanggood.springsignup.entity.MysqlUser;
import com.bbanggood.springsignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void UserSignUp(Integer setbxId, String email, String password, String name,
                       String phone, String sex, LocalDate birth) {
        MysqlUser user = new MysqlUser();

        user.setSetbxId(setbxId);
        user.setUserEmail(email);
        user.setUserPwd(passwordEncoder.encode(password));
        user.setUserName(name);
        user.setUserPhone(phone);
        user.setUserSex(sex);
        user.setUserBirth(birth);

        this.userRepository.save(user);
    }

    public void UserWithdraw(Integer setbxId) {
        Optional<MysqlUser> userOptional = Optional.ofNullable(userRepository.findBySetbxId(setbxId));

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            MysqlUser user = userOptional.get();
            userRepository.delete(user);
        } else {
            System.out.println("No user found with email: " + setbxId);
            throw new RuntimeException("No user found with email: " + setbxId);
        }
    }

    public void UpdateUserData(Integer setbxId, String newPassword, String confirmPassword,
                                String name, LocalDate birth, String sex) {
        Optional<MysqlUser> userOptional = Optional.ofNullable(userRepository.findBySetbxId(setbxId));

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            MysqlUser user = userOptional.get();

            user.setUserPwd(newPassword);
            user.setConfirmUserPwd(confirmPassword);
            user.setUserName(name);
            user.setUserBirth(birth);
            user.setUserSex(sex);

            if (newPassword.equals(confirmPassword)) {
                user.setUserPwd(passwordEncoder.encode(newPassword));
                this.userRepository.save(user);
            }
            else {
                throw new RuntimeException("Passwords do not match.");
            }
        } else {
            throw new RuntimeException("No user found with email: " + setbxId);
        }
    }
}