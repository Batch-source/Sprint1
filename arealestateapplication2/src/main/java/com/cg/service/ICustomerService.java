package com.cg.service;

import java.util.List;
import com.cg.pojo.MCustomer;

public interface ICustomerService {

	public MCustomer addCustomer(MCustomer customer);

	public MCustomer editCustomer(MCustomer customer, String userid);

	public List<MCustomer> removeCustomerById(String userid);

	public MCustomer viewCustomerById(String userid);

	public List<MCustomer> listAllCustomers();
}
