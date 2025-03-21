package com.kata.banque.acount.model;

import java.time.LocalDateTime;

public record Transaction(LocalDateTime date, double amount, double balanceAfterTransaction) {
    public Transaction(double amount, double balanceAfterTransaction) {
        this(LocalDateTime.now(), amount, balanceAfterTransaction);
    }
}
