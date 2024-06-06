package com.bbanggood.springviewrecord.controller;

import com.bbanggood.springviewrecord.DTO.ClickDTO;
import com.bbanggood.springviewrecord.service.ClickService;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/view-record")
public class ClickController {
    private final ClickService clickService;

    @PostMapping("/click")
    public String AddClickRecord(@RequestBody ClickDTO click, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        clickService.ClickPost(click.getSetbxId(), click.getVodId(), click.getViewType(), click.getClickTime());

        return "클릭 입력 완료";
    }
}
