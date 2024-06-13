package com.bbanggood.springviewrecord.service;

import com.bbanggood.springviewrecord.entity.Log;
import com.bbanggood.springviewrecord.respository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;

    public void LogPost(Integer setbxId, String vodName, Integer watchTime, Instant startTime, Instant endTime) {
        Log log = new Log();

        log.setSetbxId(setbxId);
        log.setVodName(vodName);
        log.setWatchTime(watchTime);
        log.setStartTime(startTime);
        log.setEndTime(endTime);

        logRepository.save(log);
    }
}
