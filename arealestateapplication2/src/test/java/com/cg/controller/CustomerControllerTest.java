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
import com.cg.exception.CustomerNotFoundException;
import com.cg.pojo.MCustomer;
import com.cg.service.ICustomerServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerControllerTest {
	@InjectMocks
	CustomerController control;
	@Mock
	ICustomerServiceImpl service;

	@Test
	public void listAllCustomers() {
		MCustomer c = new MCustomer("Ram", "150", "ram12", "salesman", "998844556", "ram@yahoo.com", "hyd");
		List<MCustomer> ls = new ArrayList<>();
		ls.add(c);
		Mockito.when(service.listAllCustomers()).thenReturn(ls);
		assertEquals(control.getAllCustomer().getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void addCustomer() {
		MCustomer c = new MCustomer("Diya", "102", "diya123", "clerk", "987456321", "diya@123", "pune");
		Mockito.when(service.addCustomer(c)).thenReturn(c);
		assertEquals(control.addCustomer(c).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void editCustomer() throws CustomerNotFoundException {
		MCustomer customer = new MCustomer();
		Mockito.when(service.editCustomer(customer, "101")).thenReturn(customer);
		assertEquals(control.editCustomer(customer, "101").getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void viewCustomerByIdTest() throws CustomerNotFoundException {
		MCustomer customer = new MCustomer();
		Mockito.when(service.viewCustomerById("101")).thenReturn(customer);
		assertEquals(control.viewCustomerById("101").getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void removeCustomerByIdTest() throws CustomerNotFoundException {

		List<MCustomer> customer = new ArrayList<MCustomer>();

		Mockito.when(service.removeCustomerById("103")).thenReturn(customer);
		assertEquals(control.removeCustomerById("103").getStatusCode(), HttpStatus.OK);
	}
}
