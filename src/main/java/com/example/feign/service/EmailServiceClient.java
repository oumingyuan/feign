package com.example.feign.service;


import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@FeignClient("email-service")
public interface EmailServiceClient {
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
//    String getUser() {
//        return null;
//    }

    //    @PostMapping("/send")
    @PostMapping(value = "/send",consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendEmail(@RequestBody Map<String, String> map);
}
