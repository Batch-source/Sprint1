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
import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.pojo.MBroker;
import com.cg.repository.IBrokerRepository;

@SpringBootTest
public class BrokerServiceTest {
	@Mock
	IBrokerRepository brokerRepo;
	@InjectMocks
	IBrokerServiceImpl brokerImpl;
	@Autowired
	IBrokerService brokerService;
	@Mock
	Broker broker;

	@Test
	public void addBrokerTest() {
		MBroker broker = new MBroker();
		broker.setBroName("Sunny");
		broker.setCity("hyd");
		broker.setEmail("Sunny@yahoo.com");
		broker.setMobile("999999999");
		broker.setPassword("Sunny9866");
		broker.setRole("sales");
		broker.setUserid("301");
		broker = brokerService.addBroker(broker);
		assertNotNull("broker found", broker);
		assertEquals("301", broker.getUserid());

	}

	@Test
	public void editBrokerTest() throws BrokerNotFoundException {
		MBroker broker = new MBroker();
		broker.setBroName("Sunny");
		broker.setCity("hyd");
		broker.setEmail("Sunny@yahoo.com");
		broker.setMobile("999999999");
		broker.setPassword("Sunny9866");
		broker.setRole("sales");
		broker.setUserid("102");
		broker = brokerService.editBrokerById(broker, "102");
		assertNotNull("broker found", broker);
		assertEquals(broker.getUserid(), "102");

	}

	@Test
	public void viewBrokerTest() {
		Broker broker = new Broker();
		broker.setBroName("Sunny");
		broker.setCity("hyd");
		broker.setEmail("Sunny@yahoo.com");
		broker.setMobile("999999999");
		broker.setPassword("Sunny9866");
		broker.setRole("sales");
		broker.setUserid("102");
		when(brokerRepo.findById("102")).thenReturn(Optional.of(broker));
		MBroker b = brokerImpl.viewBrokerById("102");
		assertNotNull("broker found", b);

	}

	@Test
	public void viewBrokerFailedTest() {
		when(brokerRepo.findById("101")).thenReturn(Optional.empty());
		assertThrows(" BrokerNot", BrokerNotFoundException.class, () -> brokerService.viewBrokerById("101"));

	}

	@Test
	public void listAllBrokersTest() {
		List<Broker> broker = new ArrayList<Broker>();
		Broker broker1 = new Broker();
		Broker broker2 = new Broker();
		broker.add(broker1);
		broker.add(broker2);
		when(brokerRepo.findAll()).thenReturn(broker);
		List<MBroker> list = brokerImpl.listAllBrokers();
		// assertFalse( list.size()!=0);
		assertNotNull(list);

	}
}
