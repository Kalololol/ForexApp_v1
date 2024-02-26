package com.example.ForexApp_v1.model;

import java.util.List;

import com.example.ForexApp_v1.logic.ListTransacDTOConstraint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public class TransacDTOList {
    @Valid
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
