package com.kata.banque.serviceInterface;

import java.util.List;

import com.kata.banque.acount.model.Transaction;

public interface PrintStatementService {

    public String printStatement(List<Transaction> transactions);

}
