package com.cg.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.MProperty;
import com.cg.service.IPropertyServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyControllerTest {
	@InjectMocks
	PropertyController control;
	@Mock
	IPropertyServiceImpl service;

	@Test
	public void listAllPropertiesTest() {
		MProperty p = new MProperty(100, "XXX", "xyz", 15000.00, 25.00, "Hyd", "madhapur", "Madpur", true, "101");
		List<MProperty> ls = new ArrayList<>();
		ls.add(p);
		Mockito.when(service.listAllProperties()).thenReturn(ls);
		assertEquals(control.listAllProperties().getStatusCode(), HttpStatus.OK);

	}

	@Test
	public void addPropertyTest() {
		MProperty p = new MProperty(100, "buyer", "House", 5000000.00, 25.00, "Hyd", "kompally", "kmply", true, "101");
		Mockito.when(service.addProperty(p, "101")).thenReturn(p);
		assertEquals(control.addProperty(p, "101").getStatusCode(), HttpStatus.CREATED);

	}

	@Test
	public void editPropertyTest() throws PropertyNotFoundException {
		MProperty property = new MProperty();
		Mockito.when(service.editProperty(property, "101")).thenReturn(property);
		assertEquals(control.editProperty(property, "101").getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void viewPropertyByIdTest() throws PropertyNotFoundException {
		MProperty property = new MProperty();
		Mockito.when(service.viewPropertyById(100)).thenReturn(property);
		assertEquals(control.viewPropertyById(100).getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void removePropertyByIdTest() throws PropertyNotFoundException {

		List<MProperty> property = new ArrayList<MProperty>();

		Mockito.when(service.removePropertyById(103)).thenReturn(property);
		assertEquals(control.removePropertyById(103).getStatusCode(), HttpStatus.OK);
	}

}
