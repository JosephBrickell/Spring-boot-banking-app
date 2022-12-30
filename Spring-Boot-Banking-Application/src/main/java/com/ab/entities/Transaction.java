package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	@NotEmpty
	@NotNull
	private String transactionType;
	
	@NotEmpty
	@NotNull
	private String accountNumber;
	
	
	@NotNull
	private double amount;
	
	private LocalDateTime transactionDate;

	public Transaction(@NotEmpty @NotNull String transactionType, @NotEmpty @NotNull String accountNumber,
			@NotNull double amount, LocalDateTime transactionDate) {
		super();
		this.transactionType = transactionType;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	
	

}
