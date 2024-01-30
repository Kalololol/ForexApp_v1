package com.example.ForexApp_v1;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.logic.JsonMapper;
import com.example.ForexApp_v1.model.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class CurrencyTest {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private JsonMapper jsonMapper = new JsonMapper();

    @Test
    public void jsonMapToCurrencyTest(){
        String jsonResult = "{\"table\":\"A\",\"currency\":\"dolar amerykański\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-11-02\",\"mid\":4.1963}]}";
        Currency jsonResultMapToCurrency = jsonMapper.jsonMapToCurrency(jsonResult);

        LocalDate date = LocalDate.of(2023, 11, 2);
        Currency currencyTest = new Currency(date, "usd", 4.1963);

        Assertions.assertEquals(jsonResultMapToCurrency.getCode().toLowerCase(), currencyTest.getCode());
        Assertions.assertEquals(jsonResultMapToCurrency.getDate(), currencyTest.getDate());
        Assertions.assertEquals(jsonResultMapToCurrency.getMid(), currencyTest.getMid());
    }
    @Test
    public void jsonMapToCurrencyWrongJsonTest(){
        String jsonResult = "{\"table\":\"A\",\"currency\":\"dolar amerykański\",\"codes\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"Date\":\"2023-11-02\",\"mid\":4.1963}]}";
        Currency result = jsonMapper.jsonMapToCurrency(jsonResult);

        Assertions.assertNull(result);
    }
    @Test
    public void jsonMapToCurrencyJsonIsNullTest(){
        String result = null;
        Currency currency = jsonMapper.jsonMapToCurrency(result);
        Assertions.assertNull(currency);

    }

}