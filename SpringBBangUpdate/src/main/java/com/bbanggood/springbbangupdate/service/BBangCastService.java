package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.repository.BBangCastRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BBangCastService {
    private final BBangCastRepository bbangCastRepository;

    @Transactional
    public BBangCast AddCast(Integer setbxId, String vodCast, String vodCastPoster) {
        Optional<BBangCast> castOptional = bbangCastRepository.findBySetbxIdAndVodCast(setbxId, vodCast);

        if (castOptional.isEmpty()) {
            BBangCast cast = new BBangCast();

            cast.setSetbxId(setbxId);
            cast.setVodCast(vodCast);
            cast.setVodCastPoster(vodCastPoster);

            return bbangCastRepository.save(cast);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodCast: " + vodCast);
        }
    }

    @Transactional
    public void DeleteCast(Integer setbxId, String vodCast) {
        Optional<BBangCast> castOptional = bbangCastRepository.findBySetbxIdAndVodCast(setbxId, vodCast);

        // cast가 존재하는지 확인
        if (castOptional.isPresent()) {
            BBangCast cast = castOptional.get();
            bbangCastRepository.delete(cast);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodCast: " + vodCast);
        }
    }
}
