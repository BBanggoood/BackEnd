package com.bbanggood.springbbangupdate.service;

import com.bbanggood.springbbangupdate.entity.BBangVod;
import com.bbanggood.springbbangupdate.entity.BBangVodId;
import com.bbanggood.springbbangupdate.repository.BBangVodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BBangVodService {
    private final BBangVodRepository bbangVodRepository;

    @Transactional
    public BBangVod AddVod(BBangVod bbangVod) {
        return bbangVodRepository.save(bbangVod);
    }
}
