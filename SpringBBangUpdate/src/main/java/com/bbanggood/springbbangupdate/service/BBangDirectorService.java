package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.repository.BBangDirectorRepository;
import com.bbanggood.springbbangupdate.repository.UserRepository;
import com.bbanggood.springbbangupdate.repository.VodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BBangDirectorService {
    private final BBangDirectorRepository bbangDirectorRepository;
    private final UserRepository userRepository;
    private final VodRepository vodRepository;

    @Transactional
    public BBangDirector AddDirector(Integer setbxId, String vodDirector) {
        UserMysql user = userRepository.findById(setbxId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vod vod = vodRepository.findByVodDirector(vodDirector);

        BBangDirector bbangDirector = new BBangDirector();
        BBangDirectorId bbangDirectorId = new BBangDirectorId(setbxId, vodDirector);
        bbangDirector.setBbangDirectorId(bbangDirectorId);
        bbangDirector.setUserMysql(user);
        bbangDirector.setVod(vod);

        return bbangDirectorRepository.save(bbangDirector);
    }

    @Transactional
    public void DeleteDirector(Integer setbxId, String vodDirector) {
        UserMysql user = userRepository.findById(setbxId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vod vod = vodRepository.findByVodDirector(vodDirector);

        BBangDirector bbangDirector = new BBangDirector();
        BBangDirectorId bbangDirectorId = new BBangDirectorId(setbxId, vodDirector);
        bbangDirector.setBbangDirectorId(bbangDirectorId);
        bbangDirector.setUserMysql(user);
        bbangDirector.setVod(vod);

        bbangDirectorRepository.delete(bbangDirector);
    }
}
