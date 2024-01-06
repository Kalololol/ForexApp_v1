package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.logic.CalculateTransaction;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.repositories.TransacRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacService {
    private final TransacRepository transacRepository;
    private final CurrencyDownloadApi currencyDownloadApi;
    private final CalculateTransaction calculateTransaction;

    public TransacService(TransacRepository transacRepository, CurrencyDownloadApi currencyDownloadApi, CalculateTransaction calculateTransaction) {
        this.transacRepository = transacRepository;
        this.currencyDownloadApi = currencyDownloadApi;
        this.calculateTransaction = calculateTransaction;
    }

    public Transac addTransaction(TransacDTO transacDTO){
        String date = (transacDTO.getDateTransaction().toString()).substring(0,10);
        Transac transac = calculateTransaction.manualCalculate(transacDTO.getValueCurrency(), transacDTO.getCodeCurrency(), date);
        transacRepository.createOrUpdate(transac);
        return transac;
    }
    public List<Transac> showAllTransaction(){
        return transacRepository.findAll();
    }
    public Transac findTransaction(Long id){
        return transacRepository.findById(id);
    }
    public void createOrUpdateTransaction(Transac transac){
        transacRepository.createOrUpdate(transac);
    }
    public void deleteTransaction(Transac transac){
        transacRepository.delete(transac);
    }

}
