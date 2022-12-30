package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CurrentAccount {

	@Id
	private String accountNumber;
	
	private int customerId;
	
	private String accountName;
	
	private double balance;
	
	private double overdraftLimit;
	
	private LocalDateTime dateOpened;
	
	
}
