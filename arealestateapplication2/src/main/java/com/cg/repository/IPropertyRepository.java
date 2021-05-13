package com.cg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.entity.Property;

public interface IPropertyRepository extends JpaRepository<Property, Integer> {
	@Query(value = "select p from Property p where p.offerCost>=:minCost and p.offerCost<=:maxCost and p.configuration=:configuration and p.offerType=:offerType and p.city=:city")
	public List<Property> fetchPropertyByCriteria(String configuration, String offerType, String city, double minCost,
			double maxCost);

}