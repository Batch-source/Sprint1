package com.cg.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.pojo.MCustomer;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MCustomerTest {
	@Test
	public void getTest() {
		MCustomer mcustomer = new MCustomer("Rahul", "101", "rahul123", "sales", "98746321", "rahul@123", "Hyd");
		assertEquals(mcustomer.getUserid(), "101");
		assertEquals(mcustomer.getPassword(), "rahul123");
		assertEquals(mcustomer.getRole(), "sales");
		assertEquals(mcustomer.getMobile(), "98746321");
		assertEquals(mcustomer.getEmail(), "rahul@123");
		assertEquals(mcustomer.getCity(), "Hyd");
		assertEquals(mcustomer.getCustName(), "Rahul");
	}

	@Test
	public void setTest() {
		MCustomer mcustomer = new MCustomer();
		mcustomer.setCity("Hyd");
		mcustomer.setEmail("rahul@123");
		mcustomer.setMobile("98746321");
		mcustomer.setPassword("rahul123");
		mcustomer.setRole("sales");
		mcustomer.setUserid("101");
		mcustomer.setCustName("Rahul");

		assertEquals(mcustomer.getUserid(), "101");
		assertEquals(mcustomer.getPassword(), "rahul123");
		assertEquals(mcustomer.getRole(), "sales");
		assertEquals(mcustomer.getMobile(), "98746321");
		assertEquals(mcustomer.getEmail(), "rahul@123");
		assertEquals(mcustomer.getCity(), "Hyd");
		assertEquals(mcustomer.getCustName(), "Rahul");

	}
}
