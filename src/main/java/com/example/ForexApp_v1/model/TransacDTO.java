package com.example.ForexApp_v1.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

public class TransacDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

//    @NotEmpty -- string ,
//    NotBlank -- dla string, sprawdza że nie ma pustych znaków
//    NotNull sprawdza czy pole nie jest nullem
    @NotEmpty
    private String dateTransaction;
    @NotEmpty
    private String codeCurrency;
    @NotEmpty
    private double valueCurrency;
    private double valuePln;
    private double resultTransaction;
    private boolean isDone;
    public TransacDTO(){};


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

    public double getValuePln() {
        return valuePln;
    }

    public void setValuePln(double valuePln) {
        this.valuePln = valuePln;
    }

    public double getResultTransaction() {
        return resultTransaction;
    }

    public void setResultTransaction(double resultTransaction) {
        this.resultTransaction = resultTransaction;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

}
