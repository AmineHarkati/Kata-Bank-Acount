package com.kata.banque.acount.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.banque.acount.service.BankAccountService;

@SpringBootTest
class KataApplicationTests {

	@Test
    void depositAndWithdrawOperations() {
        BankAccountService service = new BankAccountService();

        service.deposit(1000);
        service.withdraw(200);

        String statement = service.printStatement();
        assertTrue(statement.contains("1000.0"));
        assertTrue(statement.contains("-200.0"));
    }

    @Test
    void depositNegativeAmountShouldFail() {
        BankAccountService service = new BankAccountService();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.deposit(-100));
        assertEquals("Le montant du dépôt doit être positif et sup à 0"
		,exception.getMessage());
    }

    @Test
    void withdrawMoreThanBalanceShouldFail() {
        BankAccountService service = new BankAccountService();
        service.deposit(500);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.withdraw(600));
        assertEquals("Fonds insuffisants.", exception.getMessage());
    }

    @Test
    void withdrawExactBalanceShouldWork() {
        BankAccountService service = new BankAccountService();
        service.deposit(500);
        service.withdraw(500);
    }

}
