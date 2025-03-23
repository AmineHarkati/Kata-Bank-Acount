package com.kata.banque.acount.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.kata.banque.acount.model.Transaction;
import com.kata.banque.serviceInterface.PrintStatementService;

@Service
public class PrintStatementServiceImpl implements PrintStatementService {


    @Override
    public String printStatement(List<Transaction> transactions) {
        StringBuilder statement = new StringBuilder("\n=== Relevé Bancaire ===\n");
        for (Transaction transaction : transactions) {
            statement.append(transaction).append("\n");
        }
        return statement.toString();
    }
}
