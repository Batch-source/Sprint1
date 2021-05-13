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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pojo.MBroker;
import com.cg.pojo.MProperty;
import com.cg.service.IBrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/broker/v1")
public class BrokerController {
	@Autowired
	IBrokerService brokerService;
	private static final Logger LOGGER = LoggerFactory.getLogger(BrokerController.class);

	// to add broker
//	@PostMapping(path = "/addbroker")
//	public ResponseEntity<MBroker> addBroker(@Valid @RequestBody MBroker broker) {
//		LOGGER.info("Broker addBroker()");
//		MBroker mbroker = brokerService.addBroker(broker);
//		return new ResponseEntity<MBroker>(mbroker, HttpStatus.CREATED);
//	}

	// to update broker by broker Id
	@PutMapping(path = "/editbroker/{userid}")
	public ResponseEntity<MBroker> editBrokerById(@Valid @RequestBody MBroker broker, @PathVariable String userid) {
		LOGGER.info("Broker editBrokerById()");
		MBroker mbroker = brokerService.editBrokerById(broker, userid);
		return new ResponseEntity<MBroker>(mbroker, HttpStatus.OK);

	}

	// to remove broker by broker Id
	@DeleteMapping(path = "/removebroker/{broId}")
	public ResponseEntity<List<MBroker>> removeBrokerById(@PathVariable String broId) {
		LOGGER.info("Broker removeBrokerById()");
		List<MBroker> mbrokerlist = brokerService.removeBrokerById(broId);
		return new ResponseEntity<List<MBroker>>(mbrokerlist, HttpStatus.OK);
	}

	// to view broker by broker Id
	@GetMapping(path = "/viewbroker/{broId}")
	public ResponseEntity<MBroker> viewBrokerById(@PathVariable String broId) {
		LOGGER.info("Broker viewBrokerById()");
		MBroker mbroker = brokerService.viewBrokerById(broId);
		return new ResponseEntity<MBroker>(mbroker, HttpStatus.OK);
	}

	// list out all brokers
	@GetMapping(path = "/listallbrokers")
	public ResponseEntity<List<MBroker>> listAllBrokers() {
		LOGGER.info("Broker listAllBrokers()");
		List<MBroker> mbrokerlist = brokerService.listAllBrokers();
		return new ResponseEntity<List<MBroker>>(mbrokerlist, HttpStatus.OK);
	}

	// list out properties by broker Id
	@GetMapping(path = "/getallproperties/{broId}")
	public ResponseEntity<List<MProperty>> getAllPropertiesById(@PathVariable String broId) {
		LOGGER.info("Broker getAllPropertiesById()");
		List<MProperty> mbrokerlist = brokerService.getAllPropertiesById(broId);
		return new ResponseEntity<List<MProperty>>(mbrokerlist, HttpStatus.OK);
	}
}