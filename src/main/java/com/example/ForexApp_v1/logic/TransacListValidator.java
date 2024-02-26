package com.example.ForexApp_v1.logic;

import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.TransacDTOList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class TransacListValidator implements ConstraintValidator<ListTransacDTOConstraint, TransacDTOList> {
    @Override
    public void initialize(ListTransacDTOConstraint transacDTO){
    }
    @Override
    public boolean isValid(TransacDTOList transacDTOList, ConstraintValidatorContext context) {
        for(TransacDTO transacDTO : transacDTOList.getTransacDTOList()){
            LocalDate dateTransaction = LocalDate.parse(transacDTO.getDateTransaction());
            LocalDate dayMin = LocalDate.of(2022, 12, 31);
            if(Double.isNaN(transacDTO.getValueCurrency()) || transacDTO.getCodeCurrency() != null ||  dateTransaction.isBefore(LocalDate.now()) || dateTransaction.isAfter(dayMin)){
                return false;
            }
        }
        return true;
    }
}