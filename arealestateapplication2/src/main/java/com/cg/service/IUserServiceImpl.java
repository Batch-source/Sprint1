package com.cg.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Broker;
import com.cg.entity.Customer;
import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.IBrokerRepository;
import com.cg.repository.ICustomerRepository;
import com.cg.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	IBrokerRepository brokerRepository;
	@Autowired
	ICustomerRepository customerRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceImpl.class);

	// to login as broker
	@Override
	@Transactional
	public boolean brokerLogin(User user) {
		LOGGER.info("User brokerLogin()");
		Boolean status = false;
		Broker broker = brokerRepository.login(user.getUserid(), user.getPassword());
		if (broker != null) {
			status = true;
		}
		return status;
	}

	// to logout
	@Override
	@Transactional
	public boolean userLogout(User user) {
		LOGGER.info("User userLogout()");
		Boolean status = false;
		Optional<User> user1 = userRepository.findById(user.getUserid());
		if (user1.isEmpty()) {
			throw new UserNotFoundException();
		} else if (user1.get().getPassword().equals(user.getPassword())) {
			status = true;
		}
		return status;
	}

	// to login as customer
	@Override
	@Transactional
	public boolean customerLogin(User user) {
		LOGGER.info("User customerLogin()");
		Boolean status = false;
		Customer customer = customerRepository.login(user.getUserid(), user.getPassword());
		if (customer != null) {
			status = true;
		}
		return status;
	}
}