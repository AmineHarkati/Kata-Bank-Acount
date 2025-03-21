package com.kata.banque.acount.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kata.banque.acount.model.BankAccount;
import com.kata.banque.acount.model.Transaction;

@Service
public class BankAccountService {
    private final BankAccount account;
    private final List<Transaction> transactions;

    public BankAccountService() {
        this.account = new BankAccount();
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactions.add(new Transaction(amount, account.getBalance()));
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        transactions.add(new Transaction(-amount, account.getBalance()));
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder("\n=== Relevé Bancaire ===\n");
        for (Transaction transaction : transactions) {
            statement.append(transaction).append("\n");
        }
        return statement.toString();
    }

}