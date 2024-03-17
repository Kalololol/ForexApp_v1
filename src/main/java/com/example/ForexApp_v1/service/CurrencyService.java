package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.Currency;
import com.example.ForexApp_v1.repositories.CurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyService {
    private final CurrencyDAO currencyDAO;
    @Autowired
    public CurrencyService(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public List<Currency> findAllCurrency(){
        return currencyDAO.findAll();
    }
    public Currency findCurrency(Long id){
        return currencyDAO.findById(id);
    }
    public void createOrUpdateCurrency(Currency currency){
        currencyDAO.createOrUpdate(currency);
    }
    public void deleteCurrency(Currency currency){
        currencyDAO.delete(currency);
    }

}
