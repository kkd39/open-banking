package io.betterbanking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionServiceTest {
	@Autowired
	private TransactionService transactionService;
	@Test
    public void findAllByAccountNumberTest() {
        assertEquals(1, transactionService.findAllByAccountNumber(1234).size());
    }
}
