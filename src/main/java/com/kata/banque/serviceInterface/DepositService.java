package com.kata.banque.serviceInterface;

import java.util.List;

import com.kata.banque.acount.model.BankAccount;
import com.kata.banque.acount.model.Transaction;

public interface DepositService  {

    public void deposit(double amount,BankAccount account,List<Transaction> transactions);

}
