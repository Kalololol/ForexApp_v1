package com.example.ForexApp_v1.logic;

import com.example.ForexApp_v1.model.TransacDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.List;
public class TransacListValidator implements ConstraintValidator<TransacDTOConstraint, List<TransacDTO>> {
    @Override
    public void initialize(TransacDTOConstraint transacDTO){
    }
    @Override
    public boolean isValid(List<TransacDTO> transacDTOList, ConstraintValidatorContext context) {
        for(TransacDTO transacDTO : transacDTOList){
            LocalDate todayDay = LocalDate.now();
            LocalDate dateTransaction = LocalDate.parse(transacDTO.getDateTransaction());
            LocalDate dayMin = LocalDate.of(2022, 12, 31);
            //transacDTO.getValueCurrency() != null ||
            if( transacDTO.getCodeCurrency() != null ||  dateTransaction.isBefore(todayDay) || dateTransaction.isAfter(dayMin)){
                return false;
            }
        }
        return true;
    }
}