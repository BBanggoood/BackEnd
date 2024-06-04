package com.bbanggood.springuserdata.service;


import com.bbanggood.springuserdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<com.bbanggood.springuserdata.entity.UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}