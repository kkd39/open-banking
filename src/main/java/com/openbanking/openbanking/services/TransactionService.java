package com.openbanking.openbanking.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openbanking.openbanking.beans.Transaction;


@Service
public class TransactionService {
	private static List<Transaction> transactions;
	static {
		transactions=new ArrayList<>();
		transactions.add(new Transaction("Withdraw", new Date(), 1234L, "INR", 1000, "ABC"));
		transactions.add(new Transaction("Deposit", new Date(), 1234L, "INR", 1001, "ABC"));
		transactions.add(new Transaction("Withdraw", new Date(), 1234L, "INR", 1002, "ABC"));
		transactions.add(new Transaction("Deposit", new Date(), 1234L, "INR", 1003, "ABC"));
		transactions.add(new Transaction("Withdraw", new Date(), 1234L, "INR", 1004, "ABC"));
	}
	
	public List<Transaction> findAllByAccountNumber(long accountNumber) {
		return transactions.stream().filter(tr->tr.getAccountNumber()==accountNumber).toList();
		
	}

}
