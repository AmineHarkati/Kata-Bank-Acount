package com.kata.banque.serviceInterface;

import java.util.List;

import com.kata.banque.acount.model.BankAccount;
import com.kata.banque.acount.model.Transaction;

public interface WithDrawService {

    public void withdraw(double amount,BankAccount account,List<Transaction> transactions);

}
