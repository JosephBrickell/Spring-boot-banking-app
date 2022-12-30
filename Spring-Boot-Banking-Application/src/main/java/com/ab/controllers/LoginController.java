package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ab.entities.Customer;
import com.ab.services.CustomerService;


@SessionAttributes({"session_customer"})
@Controller
public class LoginController {
	
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/loginError")
	public String loginError() {
		return "loginError";
	}
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "loginForm"; // This string represents the name of JSP file without
	}
	
	
	

    @PostMapping("/login")
    public String loginCustomer(@RequestParam("email") String email,
			 					@RequestParam("password") String password, 
			 					ModelMap model) {

     int i = this.customerService.customerLogin(email, password);  
     
     System.out.println(i);
     
     if ( i == 0) {
    	   return "loginError"; 
      }
     
     else {
    	 
    	 //Storing Customer details
    	 List<Customer> customer = customerService.getCustomerDetails(email, password);
     
    	 model.put("session_customer", customer);
    	
 	 
    	 return "home"; 
      } 
     
     
     
      
     
     
     
       
       
       
    }
    
   
	
}