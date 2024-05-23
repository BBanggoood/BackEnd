package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
import com.bbanggood.springbbangupdate.entity.UserMysql;
import com.bbanggood.springbbangupdate.entity.Vod;
import com.bbanggood.springbbangupdate.repository.BBangVodRepository;
import com.bbanggood.springbbangupdate.repository.UserRepository;
import com.bbanggood.springbbangupdate.repository.VodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BBangVodService {
    private final BBangVodRepository bbangVodRepository;
    private final UserRepository userRepository;
    private final VodRepository vodRepository;

    @Transactional
    public BBangVod AddVod(Integer setbxId, Integer vodId) {
        UserMysql user = userRepository.findById(setbxId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vod vod = vodRepository.findById(vodId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid VOD ID"));

        BBangVod bbangVod = new BBangVod();
        BBangVodId bbangVodId = new BBangVodId(setbxId, vodId);
        bbangVod.setBbangVodId(bbangVodId);
        bbangVod.setUserMysql(user);
        bbangVod.setVod(vod);

        return bbangVodRepository.save(bbangVod);
    }

    @Transactional
    public void DeleteVod(Integer setbxId, Integer vodId) {
        UserMysql user = userRepository.findById(setbxId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vod vod = vodRepository.findById(vodId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid VOD ID"));

        BBangVod bbangVod = new BBangVod();
        BBangVodId bbangVodId = new BBangVodId(setbxId, vodId);
        bbangVod.setBbangVodId(bbangVodId);
        bbangVod.setUserMysql(user);
        bbangVod.setVod(vod);

        bbangVodRepository.delete(bbangVod);
    }
}
