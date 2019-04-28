package com.example.feign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {


    @RequestMapping("/health")
    public String say() {
        return "hello";
    }

}
