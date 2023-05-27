package com.openbanking.openbanking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openbanking.openbanking.beans.Transaction;
import com.openbanking.openbanking.services.TransactionService;

@RestController("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/{accountNumber}")
	public List<Transaction> getTransactions(@PathVariable Long accountNumber){
		return transactionService.findAllByAccountNumber(accountNumber);
		
	}

}
