package com.cg.controller;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
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
import com.cg.exception.DealNotFoundException;
import com.cg.pojo.MDeal;
import com.cg.service.IDealServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DealControllerTest {
	@InjectMocks
	DealController control;
	@Mock
	IDealServiceImpl service;

	@Test
	public void addDeal() {
		LocalDate d1 = null;

		MDeal d = new MDeal(101, d1, 35000.00, 200, "101");
		Mockito.when(service.addDeal(d)).thenReturn(d);
		assertEquals(control.addDeal(d).getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void viewDealByIdTest() throws DealNotFoundException {
		MDeal deal = new MDeal();
		Mockito.when(service.viewDealById(201)).thenReturn(deal);
		assertEquals(control.viewDealById(201).getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void listAllDeals() {
		LocalDate d1 = null;
		@SuppressWarnings("unused")
		MDeal d = new MDeal(101, d1, 35000.00, 200, "101");
		List<MDeal> ls = new ArrayList<>();
		Mockito.when(service.listAllDeals()).thenReturn(ls);
		assertEquals(control.listAllDeals().getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void removeDealByTest() throws DealNotFoundException {

		List<MDeal> deal = new ArrayList<MDeal>();

		Mockito.when(service.removeDealById(203)).thenReturn(deal);
		assertEquals(control.removeDealById(203).getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getAllDealsTest() throws DealNotFoundException {
		List<MDeal> deal = new ArrayList<MDeal>();

		Mockito.when(service.getAllDealsBycustomerId("abc")).thenReturn(deal);
		assertEquals(control.getAllDealsBycustomerId("abc").getStatusCode(), HttpStatus.OK);
	}
}
