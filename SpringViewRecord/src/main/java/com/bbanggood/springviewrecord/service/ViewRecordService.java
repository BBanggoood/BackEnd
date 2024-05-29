package com.bbanggood.springviewrecord.service;

import com.bbanggood.springviewrecord.entity.MysqlViewRecord;
import com.bbanggood.springviewrecord.respository.ViewRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ViewRecordService {
    private final ViewRecordRepository viewRecordRepository;

    @Transactional
    public ViewRecordPost(Integer setbxId) {
        MysqlViewRecord record = new MysqlViewRecord();

        record.setSetbxId(setbxId);
        record.setId();
    }
}
