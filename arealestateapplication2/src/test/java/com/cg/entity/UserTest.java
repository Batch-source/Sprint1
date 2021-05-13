package com.cg.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Test
	public void getTest() {
		User user = new User("101", "rahul123", "sales", "98746321", "rahul@123", "Hyd");
		assertEquals(user.getUserid(), "101");
		assertEquals(user.getPassword(), "rahul123");
		assertEquals(user.getRole(), "sales");
		assertEquals(user.getMobile(), "98746321");
		assertEquals(user.getEmail(), "rahul@123");
		assertEquals(user.getCity(), "Hyd");

	}

	@Test
	public void setTest() {
		User user = new User();
		user.setCity("Hyd");
		user.setEmail("rahul@123");
		user.setMobile("98746321");
		user.setPassword("rahul123");
		user.setRole("sales");
		user.setUserid("101");

		assertEquals(user.getUserid(), "101");
		assertEquals(user.getPassword(), "rahul123");
		assertEquals(user.getRole(), "sales");
		assertEquals(user.getMobile(), "98746321");
		assertEquals(user.getEmail(), "rahul@123");
		assertEquals(user.getCity(), "Hyd");
	}
}
