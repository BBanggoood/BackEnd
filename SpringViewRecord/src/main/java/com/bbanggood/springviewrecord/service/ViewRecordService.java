//package com.bbanggood.springviewrecord.service;
//
//import com.bbanggood.springviewrecord.entity.MysqlViewRecord;
//import com.bbanggood.springviewrecord.respository.ViewRecordRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//
//@RequiredArgsConstructor
//@Service
//public class ViewRecordService {
//    private final ViewRecordRepository viewRecordRepository;
//
//    public void ViewRecordPost(Integer setbxId, Integer vodId,
//                          String viewType, BigDecimal rating) {
//        MysqlViewRecord record = new MysqlViewRecord();
//
//        record.setSetbxId(setbxId);
//        record.setVodId(vodId);
//        record.setViewType(viewType);
//        record.setRating(rating);
//
//        this.viewRecordRepository.save(record);
//    }
//}
