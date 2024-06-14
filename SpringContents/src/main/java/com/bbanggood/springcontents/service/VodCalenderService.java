package com.bbanggood.springcontents.service;

import com.bbanggood.springcontents.dto.VodCalenderDTO;
import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.repository.VodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VodCalenderService {
    @Autowired
    private VodRepository vodRepository;

    public List<VodCalenderDTO> getVodsByDateRange(Date start, Date end) {
        List<VodEntity> vods = vodRepository.findByVodOpenAtBetween(start, end);
        return vods.stream()
                .map(vod -> new VodCalenderDTO(vod.getVodName(), vod.getVodOpenAt()))
                .collect(Collectors.toList());
    }
}
