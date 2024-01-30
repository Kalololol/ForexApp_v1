package com.example.ForexApp_v1.api;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.Date;
@Service
public class CurrencyDownloadApi {
    private final HttpClient client = HttpClient.newBuilder().build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getCurrencyExchangeRate(String code, String courseDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateFormat.parse(courseDay);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return ExchangeRateDownload(code, date);
    }
    private String ExchangeRateDownload(String code, Date day){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(day);
        HttpResponse<String> response;
        String codeLowerCase = code.toLowerCase();
        if(!(codeLowerCase.equals("usd")) && !(codeLowerCase.equals("eur"))){
            return null;
        }
        try {
            do {
                URI uri = URI.create(("http://api.nbp.pl/api/exchangerates/rates/a/" + codeLowerCase + "/" + formattedDate));
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri)
                        .GET()
                        .build();
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode() == 404){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(day);
                    calendar.add(Calendar.DAY_OF_YEAR, -1);
                    day = calendar.getTime();
                    formattedDate = dateFormat.format(day);
                }
            }while (response.statusCode() == 404);
            if(response.statusCode() == 400){
                return null;
            }
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}