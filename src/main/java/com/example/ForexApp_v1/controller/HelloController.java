package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private HelloService helloService;
    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }
    @GetMapping("/")
    public String hello() {
        // return "Hello World";
        return helloService.hello();
    }
}
