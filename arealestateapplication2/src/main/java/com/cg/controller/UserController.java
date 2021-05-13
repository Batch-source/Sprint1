package com.cg.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
@RequestMapping("/user/v1")

public class UserController {
	@Autowired
	IUserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// login as broker
	@PostMapping(value = "/brokerlogin")
	public ResponseEntity<Boolean> brokerLogin(@Valid @RequestBody User user) {
		LOGGER.info("User brokerLogin()");
		return new ResponseEntity<Boolean>(userService.brokerLogin(user), HttpStatus.OK);
	}

	// login as customer
	@PostMapping(value = "/customerlogin")
	public ResponseEntity<Boolean> customerLogin(@Valid @RequestBody User user) {
		LOGGER.info("User customerLogin()");
		return new ResponseEntity<Boolean>(userService.customerLogin(user), HttpStatus.OK);
	}

	// to logout
	@PostMapping("/logout")
	public ResponseEntity<Boolean> userLogout(@Valid @RequestBody User user) {
		LOGGER.info("User userLogout()");
		return new ResponseEntity<Boolean>(userService.userLogout(user), HttpStatus.OK);
	}
}