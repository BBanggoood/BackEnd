package com.bbanggood.springsignup.service;

import com.bbanggood.springsignup.entity.MysqlUser;
import com.bbanggood.springsignup.kafka.ChatMessage;
import com.bbanggood.springsignup.kafka.KafkaProducerService;
import com.bbanggood.springsignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import com.bbanggood.springsignup.kafka.ChatMessage;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final KafkaProducerService producerService;

    public void UserSignUp(Integer userSetbxId, String email, String password, String name,
                       String phone, String sex, LocalDate birth, Boolean userAdult, String userAdultKey,
                           String userLikeGenre, String userLikeVod, String userRole, Instant userCreatedAt, Instant userUpdatedAt) {
        MysqlUser user = new MysqlUser();

        user.setUserSetbxId(userSetbxId);
        user.setUserEmail(email);
        user.setUserPwd(passwordEncoder.encode(password));
        user.setUserName(name);
        user.setUserPhone(phone);
        user.setUserSex(sex);
        user.setUserBirth(birth);

        user.setUserAdult(userAdult);
        user.setUserAdultKey(userAdultKey);
        user.setUserLikeGenre(userLikeGenre);
        user.setUserLikeVod(userLikeVod);
        user.setUserRole(userRole);
        user.setUserCreatedAt(userCreatedAt);
        user.setUserUpdatedAt(userUpdatedAt);

        this.userRepository.save(user);
    }

    public void UserWithdraw(Integer userSetbxId) {
        Optional<MysqlUser> userOptional = Optional.ofNullable(userRepository.findByUserSetbxId(userSetbxId));

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            MysqlUser user = userOptional.get();
            userRepository.delete(user);
        } else {
            System.out.println("No user found with userSetbxId: " + userSetbxId);
            throw new RuntimeException("No user found with userSetbxId: " + userSetbxId);
        }
    }

    public void UpdateUserData(Integer userSetbxId, String newPassword, /*String confirmPassword,*/
                               String name, String sex, LocalDate birth, Boolean userAdult, String userAdultKey,
                               String userLikeGenre, String userLikeVod, String userRole, Instant userCreatedAt, Instant userUpdatedAt,
                               ChatMessage chatMessage) {
        Optional<MysqlUser> userOptional = Optional.ofNullable(userRepository.findByUserSetbxId(userSetbxId));

        // 사용자가 존재하는지 확인
        if (userOptional.isPresent()) {
            MysqlUser user = userOptional.get();

            user.setUserPwd(newPassword);
//            user.setConfirmUserPwd(confirmPassword);
            user.setUserName(name);
            user.setUserSex(sex);
            user.setUserBirth(birth);

            user.setUserAdult(userAdult);
            user.setUserAdultKey(userAdultKey);
            user.setUserLikeGenre(userLikeGenre);
            user.setUserLikeVod(userLikeVod);
            user.setUserRole(userRole);
            user.setUserCreatedAt(userCreatedAt);
            user.setUserUpdatedAt(userUpdatedAt);

            this.userRepository.save(user);

//            if (newPassword.equals(confirmPassword)) {
//                user.setUserPwd(passwordEncoder.encode(newPassword));
//            }
//            else {
//                throw new RuntimeException("Passwords do not match.");
//            }

            // kafka
            chatMessage.setUserSetbxId(user.getUserSetbxId().toString());
            chatMessage.setUserEmail(user.getUserEmail());
            chatMessage.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
            chatMessage.setUserName(user.getUserName());
            chatMessage.setUserPhone(user.getUserPhone());
            chatMessage.setUserSex(user.getUserSex());
            chatMessage.setUserBirth(user.getUserBirth().toString());

            chatMessage.setUserAdult(user.getUserAdult());
            chatMessage.setUserAdultKey((user.getUserAdultKey()));
            chatMessage.setUserLikeGenre(user.getUserLikeGenre());
            chatMessage.setUserLikeVod(user.getUserLikeVod());
            chatMessage.setUserRole(user.getUserRole());

            producerService.sendUpdateMessage(chatMessage);
        } else {
            throw new RuntimeException("No user found with userSetbxId: " + userSetbxId);
        }
    }
}