package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.Currency;
import com.example.ForexApp_v1.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> findAllCurrency(){
        return currencyRepository.findAll();
    }
    public Currency findCurrency(Long id){
        return currencyRepository.findById(id);
    }
    public void createOrUpdateCurrency(Currency currency){
        currencyRepository.createOrUpdate(currency);
    }
    public void deleteCurrency(Currency currency){
        currencyRepository.delete(currency);
    }

}
