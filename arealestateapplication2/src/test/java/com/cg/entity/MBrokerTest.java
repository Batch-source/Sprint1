package com.cg.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.pojo.MBroker;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MBrokerTest {
	@Test
	public void getTest() {
		MBroker b = new MBroker("Maya", "103", "maya254", "associator", "978594425", "maya@outlook.com", "vizag");
		assertEquals(b.getBroName(), "Maya");
		assertEquals(b.getUserid(), "103");
		assertEquals(b.getPassword(), "maya254");
		assertEquals(b.getRole(), "associator");
		assertEquals(b.getMobile(), "978594425");
		assertEquals(b.getEmail(), "maya@outlook.com");
		assertEquals(b.getCity(), "vizag");
	}

	@Test
	public void setTest() {
		MBroker b = new MBroker();
		b.setBroName("Maya");
		b.setUserid("103");
		b.setPassword("maya254");
		b.setRole("associator");
		b.setMobile("978594425");
		b.setEmail("maya@outlook.com");
		b.setCity("vizag");

		assertEquals(b.getBroName(), "Maya");
		assertEquals(b.getUserid(), "103");
		assertEquals(b.getPassword(), "maya254");
		assertEquals(b.getRole(), "associator");
		assertEquals(b.getMobile(), "978594425");
		assertEquals(b.getEmail(), "maya@outlook.com");
		assertEquals(b.getCity(), "vizag");

	}

}
