package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.TransactionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public List<Transaction> findAllTransaction(){
        return transactionRepository.findAll();
    }
    public Transaction findTransaction(Long id){
        return transactionRepository.getReferenceById(id);
    }
    public Transaction updateTransaction(Transaction transaction){
        return transactionRepository.saveAndFlush(transaction);
    }
    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }
}
