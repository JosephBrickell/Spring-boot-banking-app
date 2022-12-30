package com.ab.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Customer;
import com.ab.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
		
	}
	
	public int customerLogin(String email, String password) {
		
		return this.customerRepository.customerLogin(email, password);
		
	}
	
	public List<Customer> getCustomerDetails(String email, String password){
		
		return this.customerRepository.getCustomerDetails(email, password);
		
		
	}
	
	public List<Customer> allCustomers(){
		
		return this.customerRepository.allCustomers();
	}
	

}
