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

import com.ab.entities.CurrentAccount;
import com.ab.entities.Customer;
import com.ab.entities.Transaction;
import com.ab.helpers.AccountNumGenerator;
import com.ab.services.CurrentAccountService;
import com.ab.services.TransactionService;


@SessionAttributes({"session_customer", "current_account"})
@Controller
public class CurrentAccountController {

	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/createCurrentAccount")
	public String createCurrentAccountPage(ModelMap model) {
		
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
				
		int customerId = c.get(0).getCustomerId();
				
		//CHECK IF CUSTOMER HAS A CURRENT ACCOUNT 
		List<CurrentAccount> ca1 = currentAccountService.loadCurrentAccountByCustomerId(customerId);
		
		if (ca1.isEmpty()) {
			
		
		return "createCurrentAccount";
		
		}
		
		else {
			
			return "home";
		}
	}
	
	
	@PostMapping("/createCurrentAccountRequest")
	public String createCurrentAccount(@RequestParam("accountName") String accountName,@RequestParam ("overdraftLimit") double overdraftLimit, ModelMap model) {
		
		
		
		
		//CHECK IF THEY HAVE ADDED ACCOUNT NAME
		if (accountName.isEmpty()) {
			
			return "createCurrentAccount";
		}
		
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
		
		int customerId = c.get(0).getCustomerId();
		
		
		//GENERATE ACCOUNT NUMBER:
        int setAccountNumber = AccountNumGenerator.generateAccountNumber();
        String AccountNumber = "Curr"+Integer.toString(setAccountNumber);
        
        CurrentAccount ca = new CurrentAccount(AccountNumber, customerId, accountName, 0.00, overdraftLimit, LocalDateTime.now());
        
        //CREATE ACCOUNT
        currentAccountService.save(ca);
		
		return "home";
		
		}
		
		
	
	
	@GetMapping("/seeCurrentAccount")
	public String getCurrentAccount(ModelMap model, ModelMap model2) {
		
		//CUSTOMER ID FROM SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
		
		int customerId = c.get(0).getCustomerId();
		
		
		
		List<CurrentAccount> ca = currentAccountService.loadCurrentAccountByCustomerId(customerId);
		
		model.put("current_account", ca);
		
		if (ca.isEmpty()) {
			return "home";
		}
		
		
		String accountNumber = ca.get(0).getAccountNumber();
		
		List<Transaction> t = transactionService.loadTransactions(accountNumber);
		
		
		model2.put("transactions_List", t);
			
		return "currentAccount";
		
		
	}

	
	

	
	
	
}
