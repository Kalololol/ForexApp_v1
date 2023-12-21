package com.example.ForexApp_v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @GetMapping("/")
    public String hello() {
         return "Hello World";
       // return helloService.hello();
    }
}

