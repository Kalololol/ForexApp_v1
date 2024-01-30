package com.example.ForexApp_v1;

import com.example.ForexApp_v1.logic.CalculateTransaction;
import com.example.ForexApp_v1.model.Transac;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTransactionTest {
    private CalculateTransaction calculateTransaction = new CalculateTransaction();
    @Test
    public void manualCalculateTest(){
        Assertions.assertNotNull(calculateTransaction.manualCalculate(10, "USd", "2023-11-10"));
    }
    @Test
    public void manualCalculateWrongCodeTest(){
        Transac transaction = calculateTransaction.manualCalculate(10, "USDS", "2023-11-10");
        Assertions.assertEquals(0.0, transaction.getValuePln());
    }

}