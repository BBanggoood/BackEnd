package com.bbanggood.springcontents.controller;

import com.bbanggood.springcontents.dto.VodCalenderDTO;
import com.bbanggood.springcontents.entity.VodEntity;
import com.bbanggood.springcontents.service.VodCalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contents")
public class VodCalenderController {
    @Autowired
    private VodCalenderService vodCalenderService;

    @GetMapping("/calender")
    public List<VodCalenderDTO> getVodsByDateRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
                                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date end) {
        return vodCalenderService.getVodsByDateRange(start, end);
    }
}
