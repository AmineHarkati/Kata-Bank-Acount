package com.kata.banque.acount.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kata.banque.acount.service.BankAccountService;

@RestController
@RequestMapping("/account")
public class BankAccountController {
    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping("/deposit/{amount}")
    public ResponseEntity<String> deposit(@PathVariable double amount) {
        try{
        service.deposit(amount);
        return ResponseEntity.ok("Dépôt effectué : " + amount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : montant négatif ou 0 non autorisé");
        }
    }

    @PostMapping("/withdraw/{amount}")
    public ResponseEntity<String> withdraw(@PathVariable double amount) {
        if(amount<=0){
            return ResponseEntity.badRequest().body("montant doit etre sup à 0");
        }
        try {
            service.withdraw(amount);
            return ResponseEntity.ok("Retrait effectué : " + amount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : Solde insuffisant.");
        }
    }

    @GetMapping("/statement")
    public ResponseEntity<String> getStatement() {
        return ResponseEntity.ok(service.printStatement());
    }
}
