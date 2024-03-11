package com.example.ForexApp_v1.model;

import java.util.List;

import com.example.ForexApp_v1.validator.ListTransacDTOConstraint;
import jakarta.validation.constraints.*;


public class TransacDTOList {
    @NotEmpty(message = "Lista transakcji nie może być pusta")
    @ListTransacDTOConstraint
    private List<TransacDTO> transacDTOList;
    public List<TransacDTO> getTransacDTOList() {
        return transacDTOList;
    }
    public void setTransacDTOList(List<TransacDTO> transacDTOList) {
        this.transacDTOList = transacDTOList;
    }
}
