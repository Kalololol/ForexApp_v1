//package com.example.ForexApp_v1.logic;
//
//import com.example.ForexApp_v1.model.TransacDTO;
//import com.example.ForexApp_v1.model.TransacDTOList;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//import java.time.LocalDate;
//
//public class TransacValidator implements ConstraintValidator<TransacDTOConstraint, TransacDTO> {
//    @Override
//    public void initialize(TransacDTOConstraint transacDTO){
//    }
//    @Override
//    public boolean isValid(TransacDTO transacDTO, ConstraintValidatorContext context) {
//        LocalDate dateTransaction = LocalDate.parse(transacDTO.getDateTransaction());
//        LocalDate dayMin = LocalDate.of(2022, 12, 31);
//
//        return Double.isNaN(transacDTO.getValueCurrency()) || transacDTO.getCodeCurrency() != null ||  dateTransaction.isBefore(LocalDate.now()) || dateTransaction.isAfter(dayMin);
//    }
//}
