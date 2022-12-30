package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Transaction;
import com.ab.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	public Transaction saveTransaction(Transaction t) {
		
		return this.transactionRepo.save(t);
	}
	
	public List<Transaction> loadTransactions(String accountNumber){
		
		return this.transactionRepo.loadTransactions(accountNumber);
	}

}
