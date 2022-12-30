package com.ab.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ab.entities.SavingsAccount;
import com.ab.services.SavingsAccountService;

@SpringBootTest
public class SavingsAccountServiceTest {
	
	@Autowired
	private SavingsAccountService saService;
	
	
	// Test-case methods - methods annotated with @Test
	
	@Test
	public void testCreateCurrentAccount() {
		
		// Arrange - Create Fixtures - Input Data
		SavingsAccount sa = new SavingsAccount("Sav00001",1,"Test Savings Acc",0.00,1.5,LocalDateTime.now());
		
		// Act - Call the actual method that needs to be test  
		
		SavingsAccount actualResult = saService.save(sa);
		
		// Verify - the actual result with expected result
		
		// Use Assert methods
		
		assertNotNull(actualResult);
		
	
	}
	
}
