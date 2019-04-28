package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health")
    public String health() {
        return "health";
    }

    @RequestMapping("/getUser")
    public String getUser() {
        return "hello, user.";
    }
}
