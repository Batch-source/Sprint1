package com.cg.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pojo.MCustomer;
import com.cg.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	// to add customer
	@PostMapping(path = "/addcustomer")
	public ResponseEntity<MCustomer> addCustomer(@Valid @RequestBody MCustomer customer) {
		LOGGER.info("Customer addCustomer()");
		MCustomer mcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<MCustomer>(mcustomer, HttpStatus.CREATED);
	}

	// to update customer by customer Id
	@PutMapping(path = "/edit/{userid}")
	public ResponseEntity<MCustomer> editCustomer(@Valid @RequestBody MCustomer customer, @PathVariable String userid) {
		LOGGER.info("Customer editCustomer()");
		MCustomer mcustomer = customerService.editCustomer(customer, userid);
		return new ResponseEntity<MCustomer>(mcustomer, HttpStatus.OK);

	}

	// to remove customer by Customer Id
	@DeleteMapping(path = "/remove/{userid}")
	public ResponseEntity<List<MCustomer>> removeCustomerById(@PathVariable String userid) {
		LOGGER.info("Customer removeCustomerById()");
		List<MCustomer> mcustomerlist = customerService.removeCustomerById(userid);
		return new ResponseEntity<List<MCustomer>>(mcustomerlist, HttpStatus.OK);
	}

	// list out all customers
	@GetMapping(path = "/getall")
	public ResponseEntity<List<MCustomer>> getAllCustomer() {
		LOGGER.info("Customer getAllCustomer()");
		List<MCustomer> mcustomerlist = customerService.listAllCustomers();
		return new ResponseEntity<List<MCustomer>>(mcustomerlist, HttpStatus.OK);
	}

	// to search customer by customer Id
	@GetMapping(path = "/viewcustomerbyid/{userid}")
	public ResponseEntity<MCustomer> viewCustomerById(@PathVariable String userid) {
		LOGGER.info("Customer viewCustomerById()");
		MCustomer customer = customerService.viewCustomerById(userid);
		return new ResponseEntity<MCustomer>(customer, HttpStatus.OK);
	}
}
