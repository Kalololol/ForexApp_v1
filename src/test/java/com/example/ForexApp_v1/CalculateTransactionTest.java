package com.example.ForexApp_v1;

import logic.CalculateTransaction;
import model.Transaction;
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

        Transaction transaction = calculateTransaction.manualCalculate(10, "USDS", "2023-11-10");


        Assertions.assertNull(transaction.getValuePln());
    }
}