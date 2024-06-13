package com.bbanggood.springsignup.service;

import com.bbanggood.springsignup.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmsService {

    private final SmsUtil smsUtil;

    @Autowired
    public SmsService(SmsUtil smsUtil) {
        this.smsUtil = smsUtil;
    }

    public void sendVerificationCode(String phoneNumber) {
        String verificationCode = generateVerificationCode();
        smsUtil.sendOne(phoneNumber, verificationCode);
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 인증 코드 생성
        return String.valueOf(code);
    }
}