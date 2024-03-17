package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.logic.CalculateTransaction;
import com.example.ForexApp_v1.logic.JsonMapper;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.repositories.TransacDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacService {
    private final TransacDAO transacDAO = new TransacDAO();
    private final CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private final CalculateTransaction calculateTransaction = new CalculateTransaction();
    private final JsonMapper jsonMapper = new JsonMapper();

    public TransacDTO addTransaction(TransacDTO transacDTO){
        Transac transac = calculateTransaction.manualCalculate(transacDTO.getValueCurrency(), transacDTO.getCodeCurrency(), (transacDTO.getDateTransaction().toString()).substring(0,10));
        transacDAO.createOrUpdate(transac);

        return new TransacDTO(transac.getDateTransaction().toString(), transac.getCodeCurrency(), transac.getValueCurrency(), transac.getId(), transac.getValuePln(), transac.getResultTransaction(), transac.getIsDone());
    }
    public List<TransacDTO> addManyTransactions(List<TransacDTO> transacDTOList){
        List<TransacDTO> resultTransacList = new ArrayList<>();
        for(TransacDTO transacDTO : transacDTOList){
            resultTransacList.add(addTransaction(transacDTO));
        }
        return resultTransacList;
    }
    public List<Transac> showAllTransaction(){
        return transacDAO.findAll();
    }
    public Transac findTransaction(Long id){
        return transacDAO.findById(id);
    }
    public void createOrUpdateTransaction(Transac transac){
        transacDAO.createOrUpdate(transac);
    }
    public void deleteTransaction(Transac transac){
        transacDAO.delete(transac);
    }

}
