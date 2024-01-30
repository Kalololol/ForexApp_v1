package com.example.ForexApp_v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class CurrencyDTO {
    @JsonProperty("table")
    private  String table;
    @JsonProperty("currency")
    private  String currency;
    @JsonProperty("code")
    private  String code;
    @JsonProperty("rates")
    private  List<RateDTO> rateDTOS;

    public CurrencyDTO(){}
    public CurrencyDTO(String table, String currency, String code, List<RateDTO> rateDTOS) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rateDTOS = rateDTOS;
    }
    public String getTable() {
        return table;
    }
    public String getCurrency() {
        return currency;
    }
    public String getCode() {
        return code;
    }
    public List<RateDTO> getRates() {
        return rateDTOS;
    }

}