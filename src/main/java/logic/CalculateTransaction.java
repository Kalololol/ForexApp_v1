package logic;

import api.CurrencyDownloadApi;
import model.Currency;
import model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalculateTransaction {
    private final CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private final JsonMapper jsonMapper = new JsonMapper();
    public Transaction manualCalculate(double valueTransaction, String codeCurrency, String dateTransaction){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTransaction, formatter);

        Double valuePLN = convertCurrency(codeCurrency, dateTransaction);

        if(valuePLN ==  null || valuePLN ==  0.00) {
            Transaction transaction =  new Transaction(date, codeCurrency, valueTransaction, 0.00, 0.00, false);;
            return transaction;
        }

        double convertTransaction = valueTransaction * valuePLN;
        return new Transaction(date, codeCurrency, valueTransaction, valuePLN, convertTransaction, true);
    }

    public List<Transaction> transactionList(List<Transaction> transactionArrayList){
        List<Transaction> result = new ArrayList<>();
        for(Transaction transaction : transactionArrayList){
            result.add(automaticCalculate(transaction));
        }
        return result;
    }
    private Transaction automaticCalculate(Transaction transaction){

        String date = transaction.getDateTransaction().toString();
        Double valuePLN = convertCurrency(transaction.getCodeCurrency(), date);

        if(valuePLN == null || valuePLN == 0.00) {
            transaction.setValuePln(0.00);
            transaction.setResultTransaction(0.00);
            transaction.setDone(false);
            return transaction;
        }

        double convertTransaction = transaction.getValueCurrency() * valuePLN;
        transaction.setValuePln(valuePLN);
        transaction.setResultTransaction(convertTransaction);
        transaction.setDone(true);

        return transaction;
    }

    private double convertCurrency(String codeCurrency, String dateTransaction){
        String downloadCourse = currencyDownloadApi.getCurrencyExchangeRate(codeCurrency, dateTransaction);
        Currency currency = jsonMapper.jsonMapToCurrency(downloadCourse);
        if(currency == null){
            return 0.00;
        }
        return currency.getMid();
    }
    public double percentageResult(List<Transaction> transactionArrayList){
        int sum = 0;
        for (Transaction transaction : transactionArrayList){
            if(transaction.getIsDone() == true){
                sum++;
            }
        }
        return (sum / transactionArrayList.size()) * 100;
    }
}