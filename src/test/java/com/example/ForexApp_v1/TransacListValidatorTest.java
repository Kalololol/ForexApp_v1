package com.example.ForexApp_v1;

import com.example.ForexApp_v1.validator.TransacListValidator;
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
        Assertions.assertTrue(transacListValidator.isValid(transacDTOList, context));
    }
    @Test
    public void manyValueisValidTrueTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00, 1,23.43, 432.00, true);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("2024-02-21", "USD", 88.88);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertTrue(transacListValidator.isValid(transacDTOList, context ));
    }
    @Test
    public void isValidValueCurrencyFalseTest(){

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
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context ));
    }
    @Test
    public void isValidValueCurrencyNullFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("2024-02-21", "USD", null);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context));
    }
    @Test
    public void isEmptyDateTransactionFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("", "USD", 232.33);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context));
    }
    @Test
    public void isEmptyDateTransactionNullFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO(null, "USD", 232.33);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context ));
    }
    @Test
    public void isValidCodeCurrencyNullFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("2024-02-21", null, 232.33);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context ));
    }
    @Test
    public void isValidCodeCurrencyFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = new ArrayList<>();
        TransacDTO transacDTO1 = new TransacDTO("2024-02-22", "USD", 12.00);
        TransacDTO transacDTO2 = new TransacDTO("2024-02-21", "USD", 123.00);
        TransacDTO transacDTO3 = new TransacDTO("2024-02-21", "", 321.00);
        listTransac.add(transacDTO1);
        listTransac.add(transacDTO2);
        listTransac.add(transacDTO3);
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context ));
    }
    @Test
    public void isValidNullListFalseTest(){

        TransacDTOList transacDTOList = new TransacDTOList();
        List<TransacDTO> listTransac = null;
        transacDTOList.setTransacDTOList(listTransac);

        ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
        Assertions.assertFalse(transacListValidator.isValid(transacDTOList, context ));
    }
}
