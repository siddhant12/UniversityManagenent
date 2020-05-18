package com.universitymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String testMethod(){
        //using service discovery
        String message = restTemplate.getForObject("http://student-score/home",String.class);
        return "message returned from student-score";
    }
}
