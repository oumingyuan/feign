package com.example.feign.controller;

import com.example.feign.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private UserClient userClient;


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser() {
        return userClient.getUser();
    }

}
