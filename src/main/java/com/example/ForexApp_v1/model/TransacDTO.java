package com.example.ForexApp_v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;


public class TransacDTO {

    @NotEmpty(message = "Należy wprowadzić datę")
    @JsonProperty("date")
//    @TransacDTOConstraint
    private String dateTransaction;
    @NotBlank(message = "Kod waluty nie został wybrany")
    private String codeCurrency;
    @NotNull(message = "Należy podać wartość transakcji")
    @DecimalMin(value = "0.0001", message = "Minimalna wartość transacji to 0.0001")
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

    @Override
    public String toString() {
        return "TransacDTO{" +
                "dateTransaction='" + dateTransaction + '\'' +
                ", codeCurrency='" + codeCurrency + '\'' +
                ", valueCurrency=" + valueCurrency +
                '}';
    }
}
