package com.example.ForexApp_v1.logic;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.model.Currency;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class CalculateTransaction {
    private final CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private final JsonMapper jsonMapper = new JsonMapper();
    public Transac manualCalculate(double valueTransaction, String codeCurrency, String dateTransaction){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTransaction, formatter);

        Double valuePLN = convertCurrency(codeCurrency, dateTransaction);

        if(valuePLN ==  null || valuePLN ==  0.00) {
            Transac transaction =  new Transac(date, codeCurrency, valueTransaction, 0.00, 0.00, false);;
            return transaction;
        }

        double convertTransaction = valueTransaction * valuePLN;
        return new Transac(date, codeCurrency, valueTransaction, valuePLN, convertTransaction, true);
    }
    public List<Transac> calculateTransactionList(List<TransacDTO> transactionArrayList){
        List<Transac> result = new ArrayList<>();
        for(TransacDTO t : transactionArrayList){
            Transac transac = (manualCalculate(t.getValueCurrency(), t.getCodeCurrency(), t.getDateTransaction()));
            result.add(transac);
        }
//        for(Transac transaction : transactionArrayList){
//            result.add(automaticCalculate(transaction));
//        }
        return result;
    }
//    private Transac automaticCalculate(Transac transaction){
//
//        String date = transaction.getDateTransaction().toString();
//        Double valuePLN = convertCurrency(transaction.getCodeCurrency(), date);
//
//        if(valuePLN == null || valuePLN == 0.00) {
//            transaction.setValuePln(0.00);
//            transaction.setResultTransaction(0.00);
//            transaction.setDone(false);
//            return transaction;
//        }
//
//        double convertTransaction = transaction.getValueCurrency() * valuePLN;
//        transaction.setValuePln(valuePLN);
//        transaction.setResultTransaction(convertTransaction);
//        transaction.setDone(true);
//
//        return transaction;
//    }

    private double convertCurrency(String codeCurrency, String dateTransaction){

        String downloadCourse = currencyDownloadApi.getCurrencyExchangeRate(codeCurrency, dateTransaction);
        Currency currency = jsonMapper.jsonMapToCurrency(downloadCourse);

        if(currency == null){
            return 0.00;
        }
       // saveCurrency(currency);

        return currency.getMid();
    }
//    private void saveCurrency(Currency currency){
//        CurrencyRepository currencyRepository = new CurrencyRepository();
//        currencyRepository.createOrUpdate(currency);
//    }
    public double percentageResult(List<Transac> transactionArrayList){
        int sum = 0;
        for (Transac transaction : transactionArrayList){
            if(transaction.getIsDone() == true){
                sum++;
            }
        }
        return (sum / transactionArrayList.size()) * 100;
    }
}