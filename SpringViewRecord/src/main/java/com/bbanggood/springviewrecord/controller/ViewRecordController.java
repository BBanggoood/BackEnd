package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.service.ViewRecordService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("view-record")
public class ViewRecordController {
    private final ViewRecordService viewRecordService;
}
