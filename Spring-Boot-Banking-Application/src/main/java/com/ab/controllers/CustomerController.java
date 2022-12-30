package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ab.entities.Customer;
import com.ab.services.CustomerService;


@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/emailError")
	public String emailError() {
		
		return "emailError";
		
	}
	
	@GetMapping("/")
	public String landingPage() {
		
		return "landingPage"; 
	}
	
	@GetMapping("/registerForm")
	public String registerForm() {
		
		return "registerForm"; 
	}
	
	
	@GetMapping("/home")
	public String home() {
		
		return "home"; 
	}
	
	
	
	@PostMapping("/register")
	public String saveCustomer(@RequestParam("firstname") String firstname,
			 					 @RequestParam("lastname") String lastname,
			 					 @RequestParam("dateOfBirth") String dateOfBirth,
			 					 @RequestParam("email") String email,
			 					 @RequestParam("password") String password) {
		
		List<Customer> customers = (List<Customer>)customerService.allCustomers();
		
		for(Customer e: customers){
			
			if (e.getEmail().equalsIgnoreCase(email)) {
				
				return "emailError";
				
			}
			
			
		}
		
		
		
		Customer c = new Customer(firstname,lastname, email, dateOfBirth, password);
	
		this.customerService.saveCustomer(c);
		
		return "loginForm";
	
	}
	
	

}
