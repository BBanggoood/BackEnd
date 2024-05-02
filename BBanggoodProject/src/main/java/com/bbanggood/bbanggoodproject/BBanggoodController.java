package com.bbanggood.bbanggoodproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BBanggoodController {
    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
