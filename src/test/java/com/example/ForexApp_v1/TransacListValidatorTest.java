package com.example.ForexApp_v1;

import com.example.ForexApp_v1.logic.validator.TransacListValidator;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.TransacDTOList;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class TransacListValidatorTest {

    private TransacListValidator transacListValidator = new TransacListValidator();
    @Test
    public void isValidTrueTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("2024-02-21", "USD", 88.88);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

        boolean result = transacListValidator.isValid(transacDTOList, context );

        Assertions.assertTrue(result);
    }
    @Test
    public void isValidFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
            TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
            TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
            TransacDTO transacDTO3 = new TransacDTO("2024-02-21", "USD");
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);

        boolean result = transacListValidator.isValid(transacDTOList, context );

        Assertions.assertFalse(result);
    }
}
