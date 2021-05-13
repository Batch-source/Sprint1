package com.cg.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pojo.MDeal;
import com.cg.service.IDealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
public class DealController {
	@Autowired
	IDealService dealService;
	private static final Logger LOGGER = LoggerFactory.getLogger(DealController.class);

	// to add deal
	@PostMapping(path = "/adddeal")
	public ResponseEntity<MDeal> addDeal(@Valid @RequestBody MDeal deal) {
		LOGGER.info("Deal addDeal()");
		MDeal mdeal = dealService.addDeal(deal);
		return new ResponseEntity<MDeal>(mdeal, HttpStatus.CREATED);
	}

	// to search deal by deal Id
	@GetMapping(path = "/viewdealbyid/{dealId}")
	public ResponseEntity<MDeal> viewDealById(@PathVariable int dealId) {
		LOGGER.info("Deal viewDealById()");
		MDeal mdeal = dealService.viewDealById(dealId);
		return new ResponseEntity<MDeal>(mdeal, HttpStatus.OK);
	}

	// to search deals by customer Id
	@GetMapping(path = "/viewdealbycustid/{userid}")
	public ResponseEntity<List<MDeal>> getAllDealsBycustomerId(@PathVariable String userid) {
		LOGGER.info("Deal getAllDealsBycustomerId()");
		List<MDeal> mdeallist = dealService.getAllDealsBycustomerId(userid);
		return new ResponseEntity<List<MDeal>>(mdeallist, HttpStatus.OK);
	}

	// to remove by deal Id
	@DeleteMapping(path = "/removedealById/{dealId}")
	public ResponseEntity<List<MDeal>> removeDealById(@PathVariable int dealId) {
		LOGGER.info("Deal removeDealById()");
		List<MDeal> mdeallist = dealService.removeDealById(dealId);
		return new ResponseEntity<List<MDeal>>(mdeallist, HttpStatus.OK);
	}

	// list out deals
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getall")
	public ResponseEntity<List<MDeal>> listAllDeals() {
		LOGGER.info("Deal listAllDeals()");
		List<MDeal> mdeallist = dealService.listAllDeals();
		if (mdeallist.isEmpty()) {
			return new ResponseEntity("Sorry! Deal not available!", HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<List<MDeal>>(mdeallist, HttpStatus.OK);
	}

}