package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.BBangCast;
import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.repository.BBangVodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BBangVodService {
    private final BBangVodRepository bbangVodRepository;

    @Transactional
    public BBangVod AddVod(Integer setbxId, Integer vodId, String vodPoster) {
        Optional<BBangVod> vodOptional = bbangVodRepository.findBySetbxIdAndVodId(setbxId, vodId);

        if (vodOptional.isEmpty()) {
            BBangVod vod = new BBangVod();

            vod.setSetbxId(setbxId);
            vod.setVodId(vodId);
            vod.setVodPoster(vodPoster);

            return bbangVodRepository.save(vod);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodId: " + vodId);
        }
    }

    @Transactional
    public void DeleteVod(Integer setbxId, Integer vodId) {
        Optional<BBangVod> vodOptional = bbangVodRepository.findBySetbxIdAndVodId(setbxId, vodId);

        // vod가 존재하는지 확인
        if (vodOptional.isPresent()) {
            BBangVod vod = vodOptional.get();
            bbangVodRepository.delete(vod);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodId: " + vodId);
        }
    }
}
