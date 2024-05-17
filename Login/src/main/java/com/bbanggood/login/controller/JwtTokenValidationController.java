package com.bbanggood.login.controller;

import com.bbanggood.login.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTokenValidationController {

    private final JWTUtil jwtUtil;

    @Autowired
    public JwtTokenValidationController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            boolean isValid = !jwtUtil.isExpired(token);
            return ResponseEntity.ok().body(isValid);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}