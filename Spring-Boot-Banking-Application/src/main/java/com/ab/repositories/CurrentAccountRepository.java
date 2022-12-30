package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entities.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer>{


	
	@Query(value="SELECT * from current_account WHERE customer_id = :cacustomerId",nativeQuery=true)
	public List<CurrentAccount> loadCurrentAccountByCustomerId(@Param ("cacustomerId") int customerId);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE CurrentAccount ca SET ca.balance = :balance WHERE ca.accountNumber = :accountNumber")
	public int updateBalance(@Param("balance") double balance, @Param ("accountNumber") String accountNumber);
									 
	
}
