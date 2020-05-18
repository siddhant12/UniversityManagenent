package com.student.score;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class controller {

    @GetMapping
    public String getHelloWorld(){
        return "hello";
    }
}
