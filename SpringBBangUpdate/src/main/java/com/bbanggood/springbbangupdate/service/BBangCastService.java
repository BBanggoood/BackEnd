package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.repository.BBangCastRepository;
import com.bbanggood.springbbangupdate.repository.UserRepository;
import com.bbanggood.springbbangupdate.repository.VodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BBangCastService {
    private final BBangCastRepository bbangCastRepository;
    private final UserRepository userRepository;
    private final VodRepository vodRepository;

    @Transactional
    public BBangCast AddCast(Integer setbxId, String vodCast) {
        UserMysql user = userRepository.findById(setbxId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vod vod = vodRepository.findByVodCast(vodCast);

        BBangCast bbangCast = new BBangCast();
        BBangCastId bbangCastId = new BBangCastId(setbxId, vodCast);
        bbangCast.setBbangCastId(bbangCastId);
        bbangCast.setUserMysql(user);
        bbangCast.setVod(vod);

        return bbangCastRepository.save(bbangCast);
    }
}
