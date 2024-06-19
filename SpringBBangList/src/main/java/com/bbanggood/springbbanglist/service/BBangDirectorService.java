package com.bbanggood.springbbanglist.service;

import com.bbanggood.springbbanglist.entity.BBangDirector;
import com.bbanggood.springbbanglist.repository.BBangDirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BBangDirectorService {
    private final BBangDirectorRepository bbangDirectorRepository;

    @Transactional(readOnly = true)
    public List<BBangDirector> BBangDirectorList(String setbxId) {
        return bbangDirectorRepository.findAllBySetbxId(setbxId);
    }
}
