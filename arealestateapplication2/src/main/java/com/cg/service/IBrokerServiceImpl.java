package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Broker;
import com.cg.entity.Property;
import com.cg.exception.BrokerNotFoundException;
import com.cg.pojo.MBroker;
import com.cg.pojo.MProperty;
import com.cg.repository.IBrokerRepository;
import com.cg.repository.IPropertyRepository;

@Service
public class IBrokerServiceImpl implements IBrokerService {
	@Autowired
	IBrokerRepository brokerRepository;
	@Autowired
	IPropertyRepository propertyRepository;
	// Logger Declare
	private static final Logger LOGGER = LoggerFactory.getLogger(IBrokerServiceImpl.class);

	// adding broker
	@Override
	@Transactional
	public MBroker addBroker(MBroker broker) {
		LOGGER.info("Broker addBroker()");
		Broker brokerobj = new Broker();
		brokerobj.setBroName(broker.getBroName());
		brokerobj.setCity(broker.getCity());
		brokerobj.setEmail(broker.getEmail());
		brokerobj.setMobile(broker.getMobile());
		brokerobj.setPassword(broker.getPassword());
		brokerobj.setRole(broker.getRole());
		brokerobj.setUserid(broker.getUserid());
		brokerobj = brokerRepository.save(brokerobj);
		return broker;
	}

	// updating broker
	@Override
	@Transactional
	public MBroker editBrokerById(MBroker broker, String userid) {
		LOGGER.info("Broker editBrokerById()");
		Broker broker1 = brokerRepository.findById(userid).orElse(null);
		if (broker1 != null) {
			Broker broker2 = new Broker();
			broker2.setBroName(broker.getBroName());
			broker2.setCity(broker.getCity());
			broker2.setEmail(broker.getEmail());
			broker2.setMobile(broker.getMobile());
			broker2.setPassword(broker.getPassword());
			broker2.setRole(broker.getRole());
			broker2.setUserid(broker.getUserid());
			broker2 = brokerRepository.save(broker2);
			return broker;
		} else
			throw new BrokerNotFoundException();
	}

	// removing broker by broker Id
	@Override
	@Transactional
	public List<MBroker> removeBrokerById(String broId) {
		LOGGER.info("Broker removeBrokerById()");
		Optional<Broker> broker1 = brokerRepository.findById(broId);
		if (broker1.isPresent()) {
			brokerRepository.deleteById(broId);
			List<Broker> booklist = brokerRepository.findAll();
			List<MBroker> mbooklist = new ArrayList<>();
			for (Broker broker : booklist) {
				MBroker broker2 = new MBroker();
				broker2.setBroName(broker.getBroName());
				broker2.setCity(broker.getCity());
				broker2.setEmail(broker.getEmail());
				broker2.setMobile(broker.getMobile());
				broker2.setPassword(broker.getPassword());
				broker2.setRole(broker.getRole());
				broker2.setUserid(broker.getUserid());
				mbooklist.add(broker2);
			}
			return mbooklist;
		} else
			throw new BrokerNotFoundException();

	}

	// to search broker with broker Id
	@Override
	@Transactional
	public MBroker viewBrokerById(String broId) {
		LOGGER.info("Broker viewBrokerById()");
		Optional<Broker> broker1 = brokerRepository.findById(broId);
		if (broker1.isPresent()) {
			Broker broker = broker1.get();
			MBroker broker2 = new MBroker();
			broker2.setBroName(broker.getBroName());
			broker2.setCity(broker.getCity());
			broker2.setEmail(broker.getEmail());
			broker2.setMobile(broker.getMobile());
			broker2.setPassword(broker.getPassword());
			broker2.setRole(broker.getRole());
			broker2.setUserid(broker.getUserid());
			return broker2;
		} else
			throw new BrokerNotFoundException();
	}

	// list out all broker
	@Override
	@Transactional
	public List<MBroker> listAllBrokers() {
		LOGGER.info("Broker listAllBrokers()");
		List<Broker> brokerlist = brokerRepository.findAll();
		List<MBroker> mbrokerlist = new ArrayList<>();
		for (Broker broker : brokerlist) {
			MBroker broker1 = new MBroker();
			broker1.setBroName(broker.getBroName());
			broker1.setCity(broker.getCity());
			broker1.setEmail(broker.getEmail());
			broker1.setMobile(broker.getMobile());
			broker1.setPassword(broker.getPassword());
			broker1.setRole(broker.getRole());
			broker1.setUserid(broker.getUserid());
			mbrokerlist.add(broker1);
		}
		return mbrokerlist;
	}

	// list out all properties by broker Id
	@Override
	@Transactional
	public List<MProperty> getAllPropertiesById(String broId) {
		LOGGER.info("Broker getAllPropertiesById()");
		Optional<Broker> broker = brokerRepository.findById(broId);
		if (!broker.isPresent())
			throw new BrokerNotFoundException();
		else {
			List<Property> propertylist = propertyRepository.findAll();
			List<MProperty> mpropertylist = new ArrayList<>();
			for (Property property : propertylist) {
				MProperty mproperty = new MProperty();
				mproperty.setCity(property.getCity());
				mproperty.setConfiguration(property.getConfiguration());
				mproperty.setAddress(property.getAddress());
				mproperty.setAreaSqft(property.getAreaSqft());
				mproperty.setStreet(property.getStreet());
				mproperty.setStatus(property.isStatus());
				mproperty.setOfferCost(property.getOfferCost());
				mproperty.setOfferType(property.getOfferType());
				mproperty.setPropId(property.getPropId());
				mpropertylist.add(mproperty);
			}
			return mpropertylist;
		}
	}
}
