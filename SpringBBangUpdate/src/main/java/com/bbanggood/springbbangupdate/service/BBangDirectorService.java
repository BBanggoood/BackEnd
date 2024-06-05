package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.*;
import com.bbanggood.springbbangupdate.repository.BBangDirectorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BBangDirectorService {
    private final BBangDirectorRepository bbangDirectorRepository;

    @Transactional
    public BBangDirector AddDirector(Integer setbxId, String vodDirector, String vodDirectorPoster) {
        Optional<BBangDirector> directorOptional = bbangDirectorRepository.findBySetbxIdAndVodDirector(setbxId, vodDirector);

        if (directorOptional.isEmpty()) {
            BBangDirector director = new BBangDirector();

            director.setSetbxId(setbxId);
            director.setVodDirector(vodDirector);
            director.setVodDirectorPoster(vodDirectorPoster);

            return bbangDirectorRepository.save(director);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodDirector: " + vodDirector);
        }
    }

    @Transactional
    public void DeleteDirector(Integer setbxId, String vodDirector) {
        Optional<BBangDirector> directorOptional = bbangDirectorRepository.findBySetbxIdAndVodDirector(setbxId, vodDirector);

        // director가 존재하는지 확인
        if (directorOptional.isPresent()) {
            BBangDirector director = directorOptional.get();
            bbangDirectorRepository.delete(director);
        } else {
            throw new IllegalArgumentException("No record found with setbxId: " + setbxId + " and vodDirector: " + vodDirector);
        }
    }
}
