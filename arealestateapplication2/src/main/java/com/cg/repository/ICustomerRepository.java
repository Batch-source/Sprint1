package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
	@Query(value = "select * from customer  where userid=:userid and password=:password", nativeQuery = true)
	public Customer login(String userid, String password);

}
