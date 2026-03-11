package com.example.springboot3_basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloControlelr {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
}
