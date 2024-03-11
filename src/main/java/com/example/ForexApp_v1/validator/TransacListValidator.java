package com.example.ForexApp_v1.validator;

import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.TransacDTOList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TransacListValidator implements ConstraintValidator<ListTransacDTOConstraint, TransacDTOList> {
    @Override
    public void initialize(ListTransacDTOConstraint transacDTO){
    }
    @Override
    public boolean isValid(TransacDTOList transacDTOList, ConstraintValidatorContext context) {
        try {
            for (TransacDTO transacDTO : transacDTOList.getTransacDTOList()) {
                LocalDate dateTransaction = LocalDate.parse(transacDTO.getDateTransaction());
                LocalDate dayMin = LocalDate.of(2022, 12, 31);
                if (
                        transacDTO.getValueCurrency() == null ||
                                transacDTO.getCodeCurrency() == null ||
                                transacDTO.getCodeCurrency().isEmpty() ||
                                transacDTO.getDateTransaction().isEmpty() ||
                                dateTransaction.isAfter(LocalDate.now()) ||
                                dateTransaction.isBefore(dayMin)) {
                    return false;
                }
            }
            return true;
        }catch (NullPointerException npe){
            npe.printStackTrace();
            return false;
        }catch (DateTimeParseException dtpe){
            dtpe.printStackTrace();
            return false;
        }
    }
}