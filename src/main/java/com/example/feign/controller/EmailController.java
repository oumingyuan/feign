package com.example.feign.controller;

import com.example.feign.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class EmailController {


    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private EmailServiceClient emailServiceClient;


    @PostMapping(value = "/send")
    public void sendEmail(@RequestBody Map<String,String> map) {

        System.out.println(map);

        emailServiceClient.sendEmail(map);
    }
}
