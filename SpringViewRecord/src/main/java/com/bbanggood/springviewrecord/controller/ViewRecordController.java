//package com.bbanggood.springviewrecord.controller;
//
//import com.bbanggood.springviewrecord.DTO.ViewRecordDTO;
//import com.bbanggood.springviewrecord.service.ViewRecordService;
//import lombok.Data;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
//@Data
//@RestController
//@RequestMapping("/view-record")
//public class ViewRecordController {
//    private final ViewRecordService viewRecordService;
//
//    @PostMapping("/click")
//    public String AddViewRecord(@RequestBody ViewRecordDTO record, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
//        }
//
//        viewRecordService.ViewRecordPost(record.getSetbxId(),
//                record.getVodId(), record.getViewType(), record.getRating());
//
//        return "로그 입력";
//    }
//}
