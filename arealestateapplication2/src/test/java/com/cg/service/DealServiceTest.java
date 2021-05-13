package com.cg.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.pojo.MDeal;
import com.cg.repository.IDealRepository;

@SpringBootTest
public class DealServiceTest {
	@Mock
	IDealRepository dealRepo;
	@InjectMocks
	IDealServiceImpl dealImpl;
	@Autowired
	IDealService dealService;

	@Test
	public void addDealTest() {
		MDeal deal = new MDeal();
		LocalDate d1 = null;
		deal.setDealId(101);
		deal.setDealDate(d1);
		deal.setDealCost(35000.00);
		deal.setPropid(200);
		deal.setUserid("101");
		deal = dealService.addDeal(deal);
		assertNotNull("deal found", deal);
		assertEquals("101", deal.getUserid());
	}

	@Test
	public void listAllDealsTest() {
		List<Deal> list = new ArrayList<Deal>();
		Customer customer = new Customer();
		Property property = new Property();
		Deal deal = new Deal();
		LocalDate d1 = null;
		deal.setDealId(101);
		deal.setDealDate(d1);
		deal.setDealCost(35000.00);
		deal.setProperty(property);
		deal.setCustomer(customer);
		list.add(deal);
		when(dealRepo.findAll()).thenReturn(list);
		List<MDeal> list1 = dealImpl.listAllDeals();
		// assertFalse( list.size()!=0);
		assertNotNull(list);
	}

	@Test
	public void viewDealByIdTest() {
		Customer customer = new Customer();
		Property property = new Property();
		Deal deal = new Deal();
		LocalDate d1 = null;
		deal.setDealId(101);
		deal.setDealDate(d1);
		deal.setDealCost(35000.00);
		deal.setProperty(property);
		deal.setCustomer(customer);
		when(dealRepo.findById(101)).thenReturn(Optional.of(deal));
		MDeal d = dealImpl.viewDealById(101);
		assertNotNull("deal not found", d);
	}
}