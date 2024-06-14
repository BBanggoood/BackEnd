package com.bbanggood.springsignup.controller;

import com.bbanggood.springsignup.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send/{phoneNumber}")
    public ResponseEntity<String> sendSms(@PathVariable String phoneNumber) {
        smsService.sendVerificationCode(phoneNumber);
        return ResponseEntity.ok("SMS sent successfully");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyCode(@RequestParam String phoneNumber, @RequestParam String code) {
        boolean isVerified = smsService.verifyCode(phoneNumber, code);
        if (isVerified) {
            return ResponseEntity.ok("Verification successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid verification code");
        }
    }
}