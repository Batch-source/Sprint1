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
import com.cg.exception.BrokerNotFoundException;
import com.cg.pojo.MBroker;
import com.cg.service.IBrokerServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BrokerControllerTest {
	@InjectMocks
	BrokerController control;

	@Mock
	IBrokerServiceImpl service;

	@Test
	public void listAllBrokers() {
		MBroker b = new MBroker("Sunny", "456", "sunny12", "salesman", "998844556", "sunny@yahoo.com", "hyd");
		List<MBroker> ls = new ArrayList<>();
		ls.add(b);
		Mockito.when(service.listAllBrokers()).thenReturn(ls);
		assertEquals(control.listAllBrokers().getStatusCode(), HttpStatus.OK);

	}

	@Test
	public void addBroker() {
		MBroker b = new MBroker("Diya", "102", "diya123", "clerk", "987456321", "diya@123", "pune");
		Mockito.when(service.addBroker(b)).thenReturn(b);
		assertEquals(control.addBroker(b).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void viewBrokerByIdTest() throws BrokerNotFoundException {
		MBroker broker = new MBroker();
		Mockito.when(service.viewBrokerById("101")).thenReturn(broker);
		assertEquals(control.viewBrokerById("101").getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void editBrokerByIdTest() throws BrokerNotFoundException {
		MBroker broker = new MBroker();
		Mockito.when(service.editBrokerById(broker, "101")).thenReturn(broker);
		assertEquals(control.editBrokerById(broker, "101").getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void removeBrokerByIdTest() throws BrokerNotFoundException {

		List<MBroker> broker = new ArrayList<MBroker>();

		Mockito.when(service.removeBrokerById("103")).thenReturn(broker);
		assertEquals(control.removeBrokerById("103").getStatusCode(), HttpStatus.OK);
	}

}