package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.LogDTO;
import com.bbanggood.springviewrecord.service.LogService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/view-record")
public class LogController {
    private final LogService logService;

    @PostMapping("/log")
    public String AddLogRecord(@RequestBody LogDTO log, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        logService.LogPost(log.getSetbxId(), log.getVodId(), log.getWatchTime(), log.getStartTime(), log.getEndTime());

        return "로그 입력 완료";
    }
}
