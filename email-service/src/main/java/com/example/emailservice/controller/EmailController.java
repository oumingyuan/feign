package com.example.emailservice.controller;


import com.example.emailservice.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SendEmail sendEmail;

    @PostMapping("/send")
    public Map<String, Object> sendEmail(@RequestBody Map<String, String> map) {

        System.out.println("服务端：" + map);

        new Thread(() -> sendEmail.sendMail(
                "Test", map.get("email"), map.get("information")),
                "send email thread").start();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", "system have send an email.");

        return resultMap;


    }
}
