package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.pojo.MCustomer;
import com.cg.repository.ICustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository customerRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(IBrokerServiceImpl.class);

	// adding customer
	@Override
	@Transactional
	public MCustomer addCustomer(MCustomer customer) {
		LOGGER.info("Customer addCustomer()");
		Customer customer1 = new Customer();
		customer1.setCustName(customer.getCustName());
		customer1.setCity(customer.getCity());
		customer1.setEmail(customer.getEmail());
		customer1.setMobile(customer.getMobile());
		customer1.setPassword(customer.getPassword());
		customer1.setRole(customer.getRole());
		customer1.setUserid(customer.getUserid());
		customer1 = customerRepository.save(customer1);
		return customer;

	}

	// updating customer
	@Override
	@Transactional
	public MCustomer editCustomer(MCustomer customer, String userid) {
		LOGGER.info("Customer editCustomer()");
		Customer cust = customerRepository.findById(userid).orElse(null);
		if (cust != null) {
			Customer customer1 = new Customer();
			customer1.setCustName(customer.getCustName());
			customer1.setCity(customer.getCity());
			customer1.setEmail(customer.getEmail());
			customer1.setMobile(customer.getMobile());
			customer1.setPassword(customer.getPassword());
			customer1.setRole(customer.getRole());
			customer1.setUserid(customer.getUserid());
			customer1 = customerRepository.save(customer1);
			return customer;
		} else
			throw new CustomerNotFoundException();
	}

	// remove customer by customer Id
	@Override
	@Transactional
	public List<MCustomer> removeCustomerById(String userid) {
		LOGGER.info("Customer removeCustomerById()");
		Optional<Customer> removecustomer = customerRepository.findById(userid);
		if (!removecustomer.isPresent())
			throw new CustomerNotFoundException();
		else {
			customerRepository.deleteById(userid);
			List<Customer> customerlist = customerRepository.findAll();
			List<MCustomer> mcustomerlist = new ArrayList<>();
			for (Customer customer : customerlist) {
				MCustomer mcustomer = new MCustomer();
				mcustomer.setCustName(customer.getCustName());
				mcustomer.setCity(customer.getCity());
				mcustomer.setEmail(customer.getEmail());
				mcustomer.setMobile(customer.getMobile());
				mcustomer.setPassword(customer.getPassword());
				mcustomer.setRole(customer.getRole());
				mcustomer.setUserid(customer.getUserid());
				mcustomerlist.add(mcustomer);
			}
			return mcustomerlist;
		}
	}

	// List out all customer
	@Override
	@Transactional
	public List<MCustomer> listAllCustomers() {
		LOGGER.info("Customer listAllCustomers()");
		List<Customer> customerlist = customerRepository.findAll();
		List<MCustomer> mcustomerlist = new ArrayList<>();
		for (Customer customer : customerlist) {
			MCustomer mcustomer = new MCustomer();
			mcustomer.setCustName(customer.getCustName());
			mcustomer.setCity(customer.getCity());
			mcustomer.setEmail(customer.getEmail());
			mcustomer.setMobile(customer.getMobile());
			mcustomer.setPassword(customer.getPassword());
			mcustomer.setRole(customer.getRole());
			mcustomer.setUserid(customer.getUserid());
			mcustomerlist.add(mcustomer);
		}
		return mcustomerlist;
	}

	// to search customer by customer Id
	@Override
	@Transactional
	public MCustomer viewCustomerById(String userid) {
		LOGGER.info("Customer viewCustomerById(userid)");
		Optional<Customer> viewcustomer = customerRepository.findById(userid);
		if (!viewcustomer.isPresent())
			throw new CustomerNotFoundException();
		else {
			Customer customer = viewcustomer.get();
			MCustomer mcustomer = new MCustomer();
			mcustomer.setCustName(customer.getCustName());
			mcustomer.setCity(customer.getCity());
			mcustomer.setEmail(customer.getEmail());
			mcustomer.setMobile(customer.getMobile());
			mcustomer.setPassword(customer.getPassword());
			mcustomer.setRole(customer.getRole());
			mcustomer.setUserid(customer.getUserid());
			return mcustomer;
		}
	}
}
