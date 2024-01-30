package com.example.ForexApp_v1;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyDownloadApiTest {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();

    @Test
    public void getCurrencyExchangeRateTest(){
        String result = currencyDownloadApi.getCurrencyExchangeRate("USD", "2023-11-10");
        Assertions.assertTrue(true, result);
    }
    @Test
    public void getCurrencyExchangeRateCompareToStringTest() {
        //String compare = "{\"table\":\"A\",\"currency\":\"dolar ameryka�ski\",\"code\":\"USD\",\"rates\":[{\"no\":\"218/A/NBP/2023\",\"effectiveDate\":\"2023-11-10\",\"mid\":4.1423}]}";
        String compare = currencyDownloadApi.getCurrencyExchangeRate("usd", "2023-11-10");
        String result = currencyDownloadApi.getCurrencyExchangeRate("usd", "2023-11-10");
        Assertions.assertTrue(compare.equals(result));
    }
    @Test
    public void getCurrencyExchangeRateCompareToWrongDateTest() {
        String result = currencyDownloadApi.getCurrencyExchangeRate("usd", "2023-11-120");
        Assertions.assertNull(result);
    }
    @Test
    public void getCurrencyExchangeRateCompareToWrongCodeTest() {
        String result = currencyDownloadApi.getCurrencyExchangeRate("usd123", "2023-11-10");
        Assertions.assertNull(result);
    }
}