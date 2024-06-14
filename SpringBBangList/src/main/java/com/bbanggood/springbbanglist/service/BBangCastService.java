package com.bbanggood.springbbanglist.service;

import com.bbanggood.springbbanglist.entity.BBangCast;
import com.bbanggood.springbbanglist.repository.BBangCastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BBangCastService {
    private final BBangCastRepository bbangCastRepository;

    @Transactional(readOnly = true)
    public List<BBangCast> BBangCastList(String setbxId) {
        return bbangCastRepository.findAllBySetbxId(setbxId);
    }
}
