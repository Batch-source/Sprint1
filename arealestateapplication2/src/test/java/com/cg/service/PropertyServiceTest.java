package com.cg.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Broker;
import com.cg.entity.Property;
import com.cg.exception.BrokerNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.MBroker;
import com.cg.pojo.MCustomer;
import com.cg.pojo.MProperty;
import com.cg.repository.IBrokerRepository;
import com.cg.repository.IPropertyRepository;

@SpringBootTest
public class PropertyServiceTest {
	@Mock
	IPropertyRepository propertyRepo;
	@Mock
	IBrokerRepository brokerRepo;
	@InjectMocks
	IPropertyServiceImpl propertyImpl;
	@Autowired
	IPropertyService propertyService;

	@Test
	public void addPropertyTest() {
		MProperty property = new MProperty();
		property.setConfiguration("seller");
		property.setCity("Hyd");
		property.setOfferType("Shop");
		property.setOfferCost(1500000.00);
		property.setAreaSqft(15.00);
		property.setAddress("madhapur");
		property.setBroid("103");
		property.setPropId(100);
		property.setStatus(true);
		property.setStreet("mhd");
		property = propertyService.addProperty(property, "103");
		assertNotNull("property found", property);
		assertEquals(property.getBroid(), "103");

	}

	@Test
	public void editPropertyTest() throws PropertyNotFoundException {
		MProperty property = new MProperty();
		property.setConfiguration("seller");
		property.setCity("Hyd");
		property.setOfferType("Shop");
		property.setOfferCost(1500000.00);
		property.setAreaSqft(15.00);
		property.setAddress("madhapur");
		property.setBroid("103");
		property.setPropId(100);
		property.setStatus(true);
		property.setStreet("mhd");
		property = propertyService.addProperty(property, "102");
		assertNotNull("property found", property);
		assertEquals(property.getBroid(), "102");

	}

	@Test
	public void viewPropertyByIdTest() {
		Broker broker = new Broker();
		Property property = new Property();
		property.setConfiguration("seller");
		property.setCity("Hyd");
		property.setOfferType("Shop");
		property.setOfferCost(1500000.00);
		property.setAreaSqft(15.00);
		property.setAddress("madhapur");
		property.setPropId(201);
		property.setBroker(broker);
		property.setStatus(true);
		property.setStreet("mhd");
		when(propertyRepo.findById(201)).thenReturn(Optional.of(property));
		MProperty p = propertyImpl.viewPropertyById(201);
		assertNotNull("Property not Found", p);

	}

	@Test
	public void viewPropertyByIdFailedTest() {
		when(propertyRepo.findById(10)).thenReturn(Optional.empty());
		assertThrows(" PropertyNot", PropertyNotFoundException.class, () -> propertyImpl.viewPropertyById(10));
	}

	@Test
	public void listAllProperties() {
		List<Property> list = new ArrayList<Property>();
		Broker broker = new Broker();
		Property property = new Property();
		property.setConfiguration("seller");
		property.setCity("Hyd");
		property.setOfferType("Shop");
		property.setOfferCost(1500000.00);
		property.setAreaSqft(15.00);
		property.setAddress("madhapur");
		property.setPropId(201);
		property.setBroker(broker);
		property.setStatus(true);
		property.setStreet("mhd");
		list.add(property);
		when(propertyRepo.findAll()).thenReturn(list);
		List<MProperty> list1 = propertyImpl.listAllProperties();
		// assertFalse( list.size()!=0);
		assertNotNull(list1);

	}

}
