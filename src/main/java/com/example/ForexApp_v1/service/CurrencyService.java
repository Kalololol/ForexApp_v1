package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.CurrencyRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    public List<Currency> findAllCurrency(){
        return currencyRepository.findAll();
    }
    public Currency findCurrency(Long id){
        return currencyRepository.getReferenceById(id);
    }
    public Currency updateCurrency(Currency currency){
        return currencyRepository.saveAndFlush(currency);
    }
    public void deleteCurrency(Long id){
        currencyRepository.deleteById(id);
    }
}
