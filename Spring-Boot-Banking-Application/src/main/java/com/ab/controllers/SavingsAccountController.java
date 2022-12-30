package com.ab.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ab.entities.Customer;
import com.ab.entities.SavingsAccount;
import com.ab.entities.Transaction;
import com.ab.helpers.AccountNumGenerator;
import com.ab.services.SavingsAccountService;
import com.ab.services.TransactionService;

@SessionAttributes({"session_customer", "current_account","savings_account" })
@Controller
public class SavingsAccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/createSavingsAccount")
	public String createCurrentAccountPage(ModelMap model) {
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
						
		int customerId = c.get(0).getCustomerId();
						
		//CHECK IF CUSTOMER HAS A SAVINGS ACCOUNT 
		List<SavingsAccount> sa1 = savingsAccountService.loadSavingsAccountByCustomerId(customerId);
			
		if (sa1.isEmpty()) {
					
				
			return "createSavingsAccount";
				
		}
				
		else {
					
			return "home";
		}
	}
	
	
	@PostMapping("/createSavingsAccountRequest")
	public String createCurrentAccount(@RequestParam("accountName") String accountName, ModelMap model) {
		
		
		if (accountName.isEmpty()) {
			
			return "createSavingsAccount";
		}
		
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
		
		int customerId = c.get(0).getCustomerId();
		
		//GENERATE ACCOUNT NUMBER:
        int setAccountNumber = AccountNumGenerator.generateAccountNumber();
        String AccountNumber = "Sav"+Integer.toString(setAccountNumber);
        
        //CREATE ACCOUNT
        SavingsAccount sa = new SavingsAccount(AccountNumber, customerId, accountName, 0.00, 1.5, LocalDateTime.now());
        
        
        savingsAccountService.save(sa);
		
		return "home";
		
	}
	
	@GetMapping("/seeSavings")
	public String getSavingsAccount(ModelMap model, ModelMap model3) {
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
		
		int customerId = c.get(0).getCustomerId();
		
		
		
		List<SavingsAccount> sa = savingsAccountService.loadSavingsAccountByCustomerId(customerId);
		
		
		model.put("savings_account", sa);
		
		if (sa.isEmpty()) {
			return "home";
		}
		
		
		String accountNumber = sa.get(0).getAccountNumber();
		
		List<Transaction> t = transactionService.loadTransactions(accountNumber);
		
		
		model3.put("transactions_List", t);
		
		return "savingsAccount";
		
	}
	
	
	
}