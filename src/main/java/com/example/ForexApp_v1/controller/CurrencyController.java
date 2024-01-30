package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
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
