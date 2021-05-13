package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.DealNotFoundException;
import com.cg.pojo.MDeal;
import com.cg.repository.ICustomerRepository;
import com.cg.repository.IDealRepository;
import com.cg.repository.IPropertyRepository;

@Service
public class IDealServiceImpl implements IDealService {
	@Autowired
	IDealRepository dealRepository;
	@Autowired
	ICustomerRepository customerRepository;
	@Autowired
	IPropertyRepository propertyRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(IDealServiceImpl.class);

	// to add deal
	@Override
	@Transactional
	public MDeal addDeal(MDeal deal) {
		LOGGER.info("Deal addDeal()");
		Property property = propertyRepository.findById(deal.getPropid()).get();
		Customer customer = customerRepository.findById(deal.getUserid()).get();
		Deal deal1 = new Deal();
		deal1.setDealDate(deal.getDealDate());
		deal1.setDealCost(deal.getDealCost());
		deal1.setCustomer(customer);
		deal1.setProperty(property);
		deal1 = dealRepository.save(deal1);
		deal.setDealId(deal1.getDealId());
		return deal;
	}

	// to search deal by deal Id
	@Override
	@Transactional
	public MDeal viewDealById(int dealId) {
		LOGGER.info("Deal viewDealById()");
		Optional<Deal> deal1 = dealRepository.findById(dealId);
		if (deal1.isPresent()) {
			Deal deal = deal1.get();
			MDeal mdeal = new MDeal();
			mdeal.setDealDate(deal.getDealDate());
			mdeal.setDealCost(deal.getDealCost());
			mdeal.setDealId(deal.getDealId());
			mdeal.setPropid(deal.getProperty().getPropId());
			mdeal.setUserid(deal.getCustomer().getUserid());
			return mdeal;
		} else
			throw new DealNotFoundException();
	}

	// To list all deals
	@Override
	@Transactional
	public List<MDeal> listAllDeals() {
		LOGGER.info("Deal listAllDeals()");
		List<Deal> deallist = dealRepository.findAll();
		List<MDeal> mdeallist = new ArrayList<>();
		for (Deal deal : deallist) {
			MDeal mdeal = new MDeal();
			mdeal.setDealDate(deal.getDealDate());
			mdeal.setDealCost(deal.getDealCost());
			mdeal.setDealId(deal.getDealId());
			mdeal.setPropid(deal.getProperty().getPropId());
			mdeal.setUserid(deal.getCustomer().getUserid());
			mdeallist.add(mdeal);
		}
		return mdeallist;
	}

	// To remove deal by deal Id
	@Override
	@Transactional
	public List<MDeal> removeDealById(int dealId) {
		LOGGER.info("Deal removeDealById()");
		Optional<Deal> deal1 = dealRepository.findById(dealId);
		if (!deal1.isPresent())
			throw new DealNotFoundException();
		else {
			dealRepository.deleteById(dealId);
			List<Deal> deallist = dealRepository.findAll();
			List<MDeal> mdeallist = new ArrayList<>();
			for (Deal deal : deallist) {
				MDeal mdeal = new MDeal();
				mdeal.setDealDate(deal.getDealDate());
				mdeal.setDealCost(deal.getDealCost());
				mdeal.setDealId(deal.getDealId());
				mdeal.setPropid(deal.getProperty().getPropId());
				mdeal.setUserid(deal.getCustomer().getUserid());
				mdeallist.add(mdeal);
			}
			return mdeallist;
		}
	}

	// list out deals by customer Id
	@Override
	@Transactional
	public List<MDeal> getAllDealsBycustomerId(String userid) {
		LOGGER.info("Deal getAllDealsBycustomerId()");
		Optional<Customer> customer = customerRepository.findById(userid);
		if (!customer.isPresent())
			throw new CustomerNotFoundException();
		else {
			List<Deal> deallist = dealRepository.findAll();
			List<MDeal> mdeallist = new ArrayList<>();
			for (Deal deal : deallist) {
				MDeal mdeal = new MDeal();
				mdeal.setDealDate(deal.getDealDate());
				mdeal.setDealCost(deal.getDealCost());
				mdeal.setDealId(deal.getDealId());
				mdeal.setPropid(deal.getProperty().getPropId());
				mdeal.setUserid(deal.getCustomer().getUserid());
				mdeallist.add(mdeal);
			}
			return mdeallist;
		}
	}
}