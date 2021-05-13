package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.entity.Broker;

public interface IBrokerRepository extends JpaRepository<Broker, String> {
	@Query(value = "select * from broker  where userid=:userid and password=:password", nativeQuery = true)
	public Broker login(String userid, String password);

}
