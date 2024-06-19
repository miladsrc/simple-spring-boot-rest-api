package com.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    // HTTP GET request
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
