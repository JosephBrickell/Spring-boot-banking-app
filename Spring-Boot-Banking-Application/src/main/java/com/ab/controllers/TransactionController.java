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
import com.ab.entities.SavingsAccount;
import com.ab.entities.Transaction;
import com.ab.services.CurrentAccountService;
import com.ab.services.SavingsAccountService;
import com.ab.services.TransactionService;

@SessionAttributes({"session_customer", "current_account","savings_account" })
@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	
	@GetMapping("/amountError")
	public String amountError() {
		return "amountError";
	}
	
	@GetMapping("/depositAmount")
	public String depositAmount() {
		
		
		return "depositAmount";
	}
	
	
	@PostMapping("/depositInCurrentAccount")
	public String depositInCurrentAccount(@RequestParam ("amount") double amount, ModelMap model) {
		
		@SuppressWarnings("unchecked")
		List<CurrentAccount> ca = (List<CurrentAccount>)model.getAttribute("current_account");
		
		String accountNumber = ca.get(0).getAccountNumber();
		
		double balance = ca.get(0).getBalance();
		
		if (amount > 0) {
			
			Transaction t = new Transaction("Deposit", accountNumber, amount, LocalDateTime.now());
			
			transactionService.saveTransaction(t);
			
			balance = amount + balance;
			
			currentAccountService.updateBalance(balance, accountNumber);
			
			return "home";
			
		}
		
		else {
			return "amountError";
		}
		
		
		
	}
	
	
	@GetMapping("/withdrawAmount")
	public String withdrawAmount() {
		
		
		return "withdrawAmount";
	}
	
	
	@PostMapping("/withdrawFromCurrentAccount")
	public String withdrawFromCurrentAccount(@RequestParam ("amount") double amount, ModelMap model) {
		
		
	if ( amount > 0){
	
		@SuppressWarnings("unchecked")
		List<CurrentAccount> ca = (List<CurrentAccount>)model.getAttribute("current_account");
		
		String accountNumber = ca.get(0).getAccountNumber();
		
		double balance = ca.get(0).getBalance();
		
		double overdraftLimit = ca.get(0).getOverdraftLimit();
		
		
		
		
		if (amount <= (balance + overdraftLimit)) {
			
			Transaction t = new Transaction("Withdraw", accountNumber, amount, LocalDateTime.now());
			
			transactionService.saveTransaction(t);
			
			balance = balance - amount;
			
			currentAccountService.updateBalance(balance, accountNumber);
			
			return "home";
			
		}
		
		else {
			
			return "amountError";
		}
		
	}
		
	else {
		
	return "amountError";	
	}
	}
	
	
	
	
	
	@GetMapping("/depositAmountSavings")
	public String depositAmountSavings() {
		
		
		return "depositAmountSavings";
	}
	
	
	@PostMapping("/depositInSavingsAccount")
	public String depositInSavingsAccount(@RequestParam ("amount") double amount, ModelMap model) {
		
		
		//ENSURE CURRENT ACCOUNT IS IN SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
				
		int customerId = c.get(0).getCustomerId();
		
		List<CurrentAccount> ca = currentAccountService.loadCurrentAccountByCustomerId(customerId);
				
		model.put("current_account", ca);
		
		
		
		
		//SAVINGS ACCOUNT INFO and BALANCE
		@SuppressWarnings("unchecked")
		List<SavingsAccount> sa = (List<SavingsAccount>)model.getAttribute("savings_account");
		
		String savingsAccountNumber = sa.get(0).getAccountNumber();
		
		double savingsBalance = sa.get(0).getBalance();
		
		//CURRENT ACCOUNT INFO and BALANCE
		@SuppressWarnings("unchecked")
		List<CurrentAccount> ca2 = (List<CurrentAccount>)model.getAttribute("current_account");
		
		String currentAccountNumber = ca2.get(0).getAccountNumber();
		
		double currentAccBalance = ca2.get(0).getBalance();
		
		double overdraftLimit = ca2.get(0).getOverdraftLimit();
		
		
		if (ca.isEmpty()) {
			
			//SAVINGS ACCOUNT TRANSACTION
			Transaction t = new Transaction("Deposit", savingsAccountNumber, amount, LocalDateTime.now());
			
			transactionService.saveTransaction(t);
			
			//UPDATE SAVINGS ACC BALANCE 
			savingsBalance = amount + savingsBalance;
		
			savingsAccountService.updateBalance(savingsBalance, savingsAccountNumber);
			
			return "home";
			
		}
		
		else {
			if (amount > 0) {
				
				
				
				if (amount >= (currentAccBalance + overdraftLimit)) {
					
					return "amountError";
				}
				
				else {
			
				//SAVINGS ACCOUNT TRANSACTION
				Transaction t = new Transaction("Deposit", savingsAccountNumber, amount, LocalDateTime.now());
			
				transactionService.saveTransaction(t);
			
				//CURRENT ACCOUNT TRANSACTION
				Transaction t1 = new Transaction("withdraw", currentAccountNumber, amount, LocalDateTime.now());
			
				transactionService.saveTransaction(t1);
			
			
				//UPDATE SAVINGS ACC BALANCE 
				savingsBalance = amount + savingsBalance;
			
				savingsAccountService.updateBalance(savingsBalance, savingsAccountNumber);
			
				//UPDATE CURRENT ACC BALANCE
				currentAccBalance = currentAccBalance - amount;
			
				currentAccountService.updateBalance(currentAccBalance, currentAccountNumber);
			
				return "home";
				
				}
			
			}
		
			else {
				return "amountError";
			}
		}
	}
	
	@GetMapping("/withdrawAmountSavings")
	public String withdrawAmountSavings() {
		
		
		return "withdrawAmountSavings";
	}
	
	
	@PostMapping("/withdrawFromSavingsAccount")
	public String withdrawFromSavingsAccount(@RequestParam ("amount") double amount, ModelMap model) {
		
		
		//ENSURE CURRENT ACCOUNT IS IN SESSION
		@SuppressWarnings("unchecked")
		List<Customer> c = (List<Customer>)model.getAttribute("session_customer"); 
				
		int customerId = c.get(0).getCustomerId();
		
		List<CurrentAccount> ca = currentAccountService.loadCurrentAccountByCustomerId(customerId);
				
		model.put("current_account", ca);
		
		
		
		
		//SAVINGS ACCOUNT INFO and BALANCE
		@SuppressWarnings("unchecked")
		List<SavingsAccount> sa = (List<SavingsAccount>)model.getAttribute("savings_account");
		
		String savingsAccountNumber = sa.get(0).getAccountNumber();
		
		double savingsBalance = sa.get(0).getBalance();
		
		//CURRENT ACCOUNT INFO and BALANCE
		@SuppressWarnings("unchecked")
		List<CurrentAccount> ca2 = (List<CurrentAccount>)model.getAttribute("current_account");
		
		String currentAccountNumber = ca2.get(0).getAccountNumber();
		
		double currentAccBalance = ca2.get(0).getBalance();
		
		
		if (amount >=  savingsBalance) {
			
			return "amountError";
		}
		
		if (ca.isEmpty()) {
			
			//SAVINGS ACCOUNT TRANSACTION
			Transaction t = new Transaction("Withdraw", savingsAccountNumber, amount, LocalDateTime.now());
			
			transactionService.saveTransaction(t);
			
			//UPDATE SAVINGS ACC BALANCE 
			savingsBalance = savingsBalance - amount;
		
			savingsAccountService.updateBalance(savingsBalance, savingsAccountNumber);
			
			return "home";
			
		}
		
		else {
			if (amount > 0) {
			
				//SAVINGS ACCOUNT TRANSACTION
				Transaction t = new Transaction("Withdraw", savingsAccountNumber, amount, LocalDateTime.now());
			
				transactionService.saveTransaction(t);
			
				//CURRENT ACCOUNT TRANSACTION
				Transaction t1 = new Transaction("Deposit", currentAccountNumber, amount, LocalDateTime.now());
			
				transactionService.saveTransaction(t1);
			
			
				//UPDATE SAVINGS ACC BALANCE 
				savingsBalance = savingsBalance - amount;
			
				savingsAccountService.updateBalance(savingsBalance, savingsAccountNumber);
			
				//UPDATE CURRENT ACC BALANCE
				currentAccBalance = currentAccBalance + amount;
			
				currentAccountService.updateBalance(currentAccBalance, currentAccountNumber);
			
				return "home";
			
			}
		
			else {
				return "amountError";
			}
		}
	}
	
}
