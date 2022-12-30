package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entities.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer>{
	
	@Query(value="SELECT * from savings_account WHERE customer_id = :sacustomerId",nativeQuery=true)
	public List<SavingsAccount> loadSavingsAccountByCustomerId(@Param ("sacustomerId") int customerId);


	
	@Modifying
	@Transactional
	@Query(value = "UPDATE SavingsAccount sa SET sa.balance = :balance WHERE sa.accountNumber = :accountNumber")
	public int updateBalance(@Param("balance") double balance, @Param ("accountNumber") String accountNumber);
	
}
