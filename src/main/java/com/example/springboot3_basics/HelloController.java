package com.example.springboot3_basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable("name") String name) {
        return "Hello, " + name + "!";
    }

    // @GetMapping("/search")
    // public String search(@RequestParam("q") String query) {
    //     return "Serach results for: " + query;
    // }

    // チャランジ課題
    @GetMapping("/profile/{name}/{age}")
    public String profile(@PathVariable("name") String name, 
                          @PathVariable("age") String age) {
        return "Name: " + name + ", Age: " + age;
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "q", required = false) String query) {
        return "Serach results for: " + query;
    }
    
}
