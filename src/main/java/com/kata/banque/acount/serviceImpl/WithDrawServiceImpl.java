package com.kata.banque.acount.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kata.banque.acount.model.BankAccount;
import com.kata.banque.acount.model.Transaction;
import com.kata.banque.serviceInterface.WithDrawService;

@Service
public class WithDrawServiceImpl implements WithDrawService{

    @Override
    public void withdraw(double amount,BankAccount account,List<Transaction> transactions) {
        account.withdraw(amount);
        transactions.add(new Transaction(-amount, account.getBalance()));
    }
}
