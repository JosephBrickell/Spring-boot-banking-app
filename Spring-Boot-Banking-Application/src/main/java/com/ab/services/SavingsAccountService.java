package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.SavingsAccount;
import com.ab.repositories.SavingsAccountRepository;

@Service
public class SavingsAccountService {

	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	
	
	public SavingsAccount save(SavingsAccount sa) {
		
		return this.savingsAccountRepository.save(sa);
	}
	
	public List<SavingsAccount> loadSavingsAccountByCustomerId(int customerId){
		
		return this.savingsAccountRepository.loadSavingsAccountByCustomerId(customerId);
		
	}
	
	
	public int updateBalance(double balance, String accountNumber) {
		
		
		
		return this.savingsAccountRepository.updateBalance(balance, accountNumber);
		
		
		
	}
	
	
	
}