package com.example.ForexApp_v1.service;

import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello() {
        return "Hello World";
    }
}
