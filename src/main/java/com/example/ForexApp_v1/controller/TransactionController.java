package com.example.ForexApp_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {
    @GetMapping("/singleTransaction")
    public String showToSingleTransaction() {
        return "singleTransaction";
    }
//    @PostMapping
//    public String addToSingleTransaction(){
//        return "/addToSingleTransaction";
//    }
    @GetMapping("/manyTransactions")
    public String showToManyTransactions(){
        return "manyTransactions";
    }
//    @PostMapping("/manyTransactions")
//    public String addToManyTransactions(){
//        return "/addToManyTransactions";
//    }
}
