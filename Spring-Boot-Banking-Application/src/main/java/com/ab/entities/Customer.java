package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	
	@NotEmpty(message = "First Name may not be empty")
	@Size(min = 2, max = 32, message = "First Name must be between 2 and 32 characters long")
	private String firstname;
	
	@NotEmpty(message = "Last Name may not be empty")
	@Size(min = 3, max = 32, message = "Last Name must be between 3 and 32 characters long")
	private String lastname;
	
	
	@Email
    @NotEmpty
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", message = "Please Enter a Valid Email")
	private String email;
	
	
	@NotEmpty
	@Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])[0-9]{2})", message = "Please Eneter a Valid DOB in format dd-mm-yyyy")
	private String dateOfBirth;
	
	@NotEmpty
    @NotNull
    @Size(min = 4, max = 50, message = "Password needs to be between 4 and 50 characters long")
	private String password;

	public Customer(
			@NotEmpty(message = "First Name may not be empty") @Size(min = 2, max = 32, message = "First Name must be between 2 and 32 characters long") String firstname,
			@NotEmpty(message = "Last Name may not be empty") @Size(min = 3, max = 32, message = "Last Name must be between 3 and 32 characters long") String lastname,
			@Email @NotEmpty @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", message = "Please Enter a Valid Email") String email,
			@NotEmpty @Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])[0-9]{2})", message = "Please Eneter a Valid DOB in format dd-mm-yyyy") String dateOfBirth,
			@NotEmpty @NotNull @Size(min = 4, max = 50, message = "Password needs to be between 4 and 50 characters long") String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}
	
	
	
	

}


