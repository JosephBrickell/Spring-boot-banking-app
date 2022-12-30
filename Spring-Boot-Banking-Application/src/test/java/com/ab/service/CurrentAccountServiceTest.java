package com.ab.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.ab.entities.CurrentAccount;
import com.ab.services.CurrentAccountService;

@SpringBootTest
public class CurrentAccountServiceTest {
	
	@Autowired
	private CurrentAccountService caService;
	
	
	// Test-case methods - methods annotated with @Test
	
	@Test
	public void testCreateCurrentAccount() {
		
		// Arrange - Create Fixtures - Input Data
		CurrentAccount ca = new CurrentAccount("Curr00001",1,"Test Current Acc",0.00,1000.0,LocalDateTime.now());
		
		// Act - Call the actual method that needs to be test  
		
		CurrentAccount actualResult = caService.save(ca);
		
		// Verify - the actual result with expected result
		
		// Use Assert methods
		
		assertNotNull(actualResult);
		
	
	}
	
}
