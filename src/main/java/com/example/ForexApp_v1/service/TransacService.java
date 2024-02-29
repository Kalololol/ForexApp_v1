package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.logic.CalculateTransaction;
import com.example.ForexApp_v1.logic.JsonMapper;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.repositories.CurrencyRepository;
import com.example.ForexApp_v1.repositories.TransacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacService {
    private final TransacRepository transacRepository;
    private final CurrencyDownloadApi currencyDownloadApi;
    private final CalculateTransaction calculateTransaction;
    private final JsonMapper jsonMapper;
    @Autowired
    public TransacService(TransacRepository transacRepository, CurrencyDownloadApi currencyDownloadApi, CalculateTransaction calculateTransaction, JsonMapper jsonMapper) {
        this.transacRepository = transacRepository;
        this.currencyDownloadApi = currencyDownloadApi;
        this.calculateTransaction = calculateTransaction;
        this.jsonMapper = jsonMapper;
    }

    public TransacDTO addTransaction(TransacDTO transacDTO){
        Transac transac = calculateTransaction.manualCalculate(transacDTO.getValueCurrency(), transacDTO.getCodeCurrency(), (transacDTO.getDateTransaction().toString()).substring(0,10));
        transacRepository.createOrUpdate(transac);

        TransacDTO result = new TransacDTO(transac.getDateTransaction().toString(), transac.getCodeCurrency(), transac.getValueCurrency(), transac.getId(), transac.getValuePln(), transac.getResultTransaction(), transac.getIsDone());

        return result;
    }
    public List<TransacDTO> addManyTransactions(List<TransacDTO> transacDTOList){
        List<TransacDTO> resultTransacList = new ArrayList<>();
        for(TransacDTO transacDTO : transacDTOList){
            resultTransacList.add(addTransaction(transacDTO));
        }
        return resultTransacList;
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
