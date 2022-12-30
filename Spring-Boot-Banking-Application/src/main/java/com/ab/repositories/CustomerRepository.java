package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ab.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByEmailAndPassword(String email, String password);
	
	@Query(value = "SELECT * FROM Customer c WHERE c.email = :cemail and c.password = :cpassword", nativeQuery = true)
    public int customerLogin(@Param("cemail")String email, @Param("cpassword") String password );
	
	
	@Query(value = "SELECT * FROM Customer c WHERE c.email = :cemail and c.password = :cpassword", nativeQuery = true)
    public List<Customer> getCustomerDetails(@Param("cemail")String email, @Param("cpassword") String password );
	
	
	@Query(value= "SELECT * FROM Customer", nativeQuery = true)
	public List<Customer> allCustomers();
	
	
	
	
	
}
