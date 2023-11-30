package com.example.ForexApp_v1.model;

import java.time.LocalDate;

public class Transaction {
    private LocalDate dateTransaction;
    private String codeCurrency;
    private double valueCurrency;
    private double valuePln;
    private double resultTransaction;
    private boolean isDone;

    public Transaction(LocalDate dateTransaction, String codeCurrency, double valueCurrency) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
    }
    public Transaction(LocalDate dateTransaction, String codeCurrency, double valueCurrency, double valuePln, double resultTransaction, boolean isDone) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
        this.valuePln = valuePln;
        this.resultTransaction = resultTransaction;
        this.isDone = isDone;
    }
    public void setResultTransaction(double resultTransaction) {
        this.resultTransaction = resultTransaction;
    }
    public LocalDate getDateTransaction() {
        return dateTransaction;
    }
    public String getCodeCurrency() {
        return codeCurrency;
    }
    public double getValueCurrency() {
        return valueCurrency;
    }
    public double getValuePln() {
        return valuePln;
    }
    public double getResultTransaction() {
        return resultTransaction;
    }
    public void setValuePln(double valuePln) {
        this.valuePln = valuePln;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateTransaction=" + dateTransaction +
                ", codeCurrency='" + codeCurrency + '\'' +
                ", valueCurrency=" + valueCurrency +
                ", valuePln=" + valuePln +
                ", resultTransaction=" + resultTransaction +
                ", isDone=" + isDone +
                '}';
    }
}