package com.example.emailservice.controller;

//import mingyuaninformation.email.service.SendEmail;
import com.example.emailservice.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class EmailController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SendEmail sendEmail;

    @PostMapping("/send")
    public CompletableFuture<Map> sendEmail(String email, String information) {

        System.out.println("email: " + email);
        System.out.println("information: " + information);

        return sendEmail.sendMail("Test", email, information);

    }
}
