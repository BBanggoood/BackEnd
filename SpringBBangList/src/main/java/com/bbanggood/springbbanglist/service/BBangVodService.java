package com.bbanggood.springbbanglist.service;

import com.bbanggood.springbbanglist.entity.BBangVod;
import com.bbanggood.springbbanglist.repository.BBangVodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BBangVodService {
    private final BBangVodRepository bbangVodRepository;

    @Transactional(readOnly = true)
    public List<BBangVod> BBangVodList(Integer setbxId) {
        return bbangVodRepository.findAllBySetbxId(setbxId);
    }
}
