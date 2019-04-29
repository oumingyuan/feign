package com.example.emailservice.controller;

//import mingyuaninformation.email.service.SendEmail;

import com.example.emailservice.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class EmailController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SendEmail sendEmail;

    @PostMapping("/send")
    public void sendEmail(@RequestBody Map<String, String> map) {

//        System.out.println("email: " + email);
//        System.out.println("information: " + information);
        System.out.println("服务端：" + map);

        sendEmail.sendMail("Test", map.get("email"), map.get("information"));

    }
}
