package com.example.ForexApp_v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

public class TransacDTO {

//    @NotEmpty -- string ,
//    NotBlank -- dla string, sprawdza że nie ma pustych znaków
//    NotNull sprawdza czy pole nie jest nullem
    @NotEmpty
    @JsonProperty("date")
    private String dateTransaction;
    @NotEmpty
    private String codeCurrency;
    @NotEmpty
    private double valueCurrency;

    public TransacDTO(){};

    public TransacDTO(String dateTransaction, String codeCurrency, double valueCurrency) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
    }

    public String getCodeCurrency() {
        return codeCurrency;
    }
    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }
    public double getValueCurrency() {
        return valueCurrency;
    }
    public void setValueCurrency(double valueCurrency) {
        this.valueCurrency = valueCurrency;
    }
    public String getDateTransaction() {
        return dateTransaction;
    }
    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

}
