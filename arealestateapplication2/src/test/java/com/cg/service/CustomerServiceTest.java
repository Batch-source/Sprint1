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

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.pojo.MCustomer;
import com.cg.repository.ICustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	@Mock
	ICustomerRepository customerRepo;
	@InjectMocks
	ICustomerServiceImpl customerImpl;
	@Autowired
	ICustomerService customerService;

	@Test
	public void addCustomerTest() {
		MCustomer customer = new MCustomer();
		customer.setCustName("Divya");
		customer.setCity("hyd");
		customer.setEmail("divya@yahoo.com");
		customer.setMobile("999999999");
		customer.setPassword("divya9866");
		customer.setRole("clerk");
		customer.setUserid("301");
		customer = customerService.addCustomer(customer);
		assertNotNull("customer found", customer);
		assertEquals("301", customer.getUserid());

	}

	@Test
	public void editCustomerTest() throws CustomerNotFoundException {
		MCustomer customer = new MCustomer();
		customer.setCustName("Sunny");
		customer.setCity("hyd");
		customer.setEmail("Sunny@yahoo.com");
		customer.setMobile("999999999");
		customer.setPassword("Sunny9866");
		customer.setRole("sales");
		customer.setUserid("101");
		customer = customerService.editCustomer(customer, "101");
		assertNotNull("customer found", customer);
		assertEquals(customer.getUserid(), "101");

	}
	@Test
	public void viewCustomerByIdTest() {
		Customer customer = new Customer();
		customer.setCustName("Sunny");
		customer.setCity("hyd");
		customer.setEmail("Sunny@yahoo.com");
		customer.setMobile("999999999");
		customer.setPassword("Sunny9866");
		customer.setRole("sales");
		customer.setUserid("101");
		when(customerRepo.findById("102")).thenReturn(Optional.of(customer));
		 MCustomer c =customerImpl.viewCustomerById("102");
				assertNotNull("customerfound",c);
		
	}
//	@Test
//	public  void viewCustomerByIdFailedTest() {	
//		when(customerRepo.findById("101")).thenReturn(Optional.empty());
//	    assertThrows(" CustomerNotFoundException",CustomerNotFoundException.class, () -> customerService.viewCustomerById("101"));
//	}     	
	@Test
	public void listAllCustomersTest() {
		List<Customer> customer= new ArrayList<Customer>();
		Customer customer1=new Customer();
		Customer customer2=new Customer();
		customer.add(customer1);
		customer.add(customer2);
		when(customerRepo.findAll()).thenReturn(customer);
		List<MCustomer> list=customerImpl.listAllCustomers();
		//assertFalse( list.size()!=0);
		assertNotNull(list);	
	}
}


