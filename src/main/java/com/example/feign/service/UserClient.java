package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("service-0")
public interface UserClient {


    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    String getUser();

}
