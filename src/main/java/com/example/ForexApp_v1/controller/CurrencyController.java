package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    @GetMapping("/currencies")
    public List<Currency> getCurrencies(){
        throw new IllegalArgumentException("Not implement yet!");
    }
    @GetMapping("/currencies/")
    public Currency getSingleCurrency(long id){
        throw new IllegalArgumentException("Not implement yet!");
    }

}
