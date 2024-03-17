package com.example.ForexApp_v1.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Table(name = "Transaction")
@Entity
public class Transac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateTransaction;
    private String codeCurrency;
    private Double valueCurrency;
    private Double valuePln;
    private Double resultTransaction;
    private boolean isDone;
    //private long idTransacGroup;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser customUser;
    public Transac(){};
    public Transac(LocalDate dateTransaction, String codeCurrency, Double valueCurrency) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
    }
    public Transac(LocalDate dateTransaction, String codeCurrency, Double valueCurrency, Double valuePln, Double resultTransaction, boolean isDone) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
        this.valuePln = valuePln;
        this.resultTransaction = resultTransaction;
        this.isDone = isDone;
    }

    public Transac(long id, LocalDate dateTransaction, String codeCurrency, Double valueCurrency, Double valuePln, Double resultTransaction, boolean isDone) {
        this.id = id;
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
        this.valuePln = valuePln;
        this.resultTransaction = resultTransaction;
        this.isDone = isDone;
    }

    public void setResultTransaction(Double resultTransaction) {
        this.resultTransaction = resultTransaction;
    }
    public LocalDate getDateTransaction() {
        return dateTransaction;
    }
    public String getCodeCurrency() {
        return codeCurrency;
    }
    public Double getValueCurrency() {
        return valueCurrency;
    }
    public Double getValuePln() {
        return valuePln;
    }
    public Double getResultTransaction() {
        return resultTransaction;
    }
    public void setValuePln(Double valuePln) {
        this.valuePln = valuePln;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void setDone(boolean done) {
        isDone = done;
    }
    public long getId() {
        return id;
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