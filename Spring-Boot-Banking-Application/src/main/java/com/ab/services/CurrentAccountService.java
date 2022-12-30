package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.CurrentAccount;
import com.ab.repositories.CurrentAccountRepository;

@Service
public class CurrentAccountService {

	@Autowired
	private CurrentAccountRepository currentAccountRepository;
	
	
	
	public CurrentAccount save(CurrentAccount ca) {
		
		return this.currentAccountRepository.save(ca);
	}
	
	
	public List<CurrentAccount> loadCurrentAccountByCustomerId(int customerId){
		
		return this.currentAccountRepository.loadCurrentAccountByCustomerId(customerId);
		
	}

	public int updateBalance(double balance, String accountNumber) {
		
		
		
		return this.currentAccountRepository.updateBalance(balance, accountNumber);
		
		
		
	}
	
	
	
}