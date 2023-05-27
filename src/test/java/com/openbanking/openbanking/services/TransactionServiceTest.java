package com.openbanking.openbanking.services;

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
		assertEquals(5, transactionService.findAllByAccountNumber(1234L).size());
		
	}
}
