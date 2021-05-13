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
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.MProperty;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.IBrokerRepository;
import com.cg.repository.IPropertyRepository;

@Service
public class IPropertyServiceImpl implements IPropertyService {
	@Autowired
	IPropertyRepository propertyRepository;
	@Autowired
	IBrokerRepository brokerRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(IPropertyServiceImpl.class);

	// add property by broker Id
	@Override
	@Transactional
	public MProperty addProperty(MProperty property, String broId) {
		LOGGER.info("Property addProperty()");
		Broker broker = brokerRepository.findById(broId).orElse(null);
		if (broker != null) {
			Broker broker1 = broker;
			Property propertyobj = new Property();
			propertyobj.setCity(property.getCity());
			propertyobj.setConfiguration(property.getConfiguration());
			propertyobj.setAddress(property.getAddress());
			propertyobj.setAreaSqft(property.getAreaSqft());
			propertyobj.setStreet(property.getStreet());
			propertyobj.setStatus(property.isStatus());
			propertyobj.setOfferCost(property.getOfferCost());
			propertyobj.setOfferType(property.getOfferType());
			propertyobj.setBroker(broker);
			propertyobj = propertyRepository.save(propertyobj);
			broker1.getProperties().add(propertyobj);
			brokerRepository.save(broker1);
			property.setPropId(propertyobj.getPropId());
			property.setBroid(broId);
			return property;
		} else
			throw new PropertyNotFoundException();
	}

	// To update property by broker Id
	@Override
	@Transactional
	public MProperty editProperty(MProperty property, String broId) {
		LOGGER.info("Property editProperty()");
		Broker broker = brokerRepository.findById(broId).orElse(null);
		if (broker != null) {
			Broker broker1 = broker;
			Property propertyobj = new Property();
			propertyobj.setCity(property.getCity());
			propertyobj.setConfiguration(property.getConfiguration());
			propertyobj.setAddress(property.getAddress());
			propertyobj.setAreaSqft(property.getAreaSqft());
			propertyobj.setStreet(property.getStreet());
			propertyobj.setStatus(property.isStatus());
			propertyobj.setOfferCost(property.getOfferCost());
			propertyobj.setOfferType(property.getOfferType());
			propertyobj.setBroker(broker);
			propertyobj.setPropId(property.getPropId());
			propertyobj = propertyRepository.save(propertyobj);
			broker1.getProperties().add(propertyobj);
			brokerRepository.save(broker1);
			property.setPropId(propertyobj.getPropId());
			property.setBroid(broId);
			return property;
		} else
			throw new PropertyNotFoundException();
	}

	// list out all properties
	@Override
	@Transactional
	public List<MProperty> listAllProperties() {
		LOGGER.info("Property listAllProperties()");
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
			mproperty.setBroid(property.getBroker().getUserid());
			mpropertylist.add(mproperty);
		}
		return mpropertylist;
	}

	// to search property by property Id
	@Override
	@Transactional
	public MProperty viewPropertyById(int propId) {
		LOGGER.info("Property viewPropertyById()");
		Optional<Property> propertyobj = propertyRepository.findById(propId);
		if (!propertyobj.isPresent())
			throw new PropertyNotFoundException();
		else {
			Property property = propertyobj.get();
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
			mproperty.setBroid(property.getBroker().getUserid());
			return mproperty;
		}
	}

	// to remove property by property Id
	@Override
	@Transactional
	public List<MProperty> removePropertyById(int propId) {
		LOGGER.info("Property removePropertyById()");
		Optional<Property> propertyobj = propertyRepository.findById(propId);
		if (!propertyobj.isPresent())
			throw new PropertyNotFoundException();
		else {
			propertyRepository.deleteById(propId);
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
				mproperty.setBroid(property.getBroker().getUserid());
				mpropertylist.add(mproperty);
			}
			return mpropertylist;
		}
	}

	// list out property by given criteria
	@Override
	@Transactional
	public List<MProperty> listPropertyByCriteria(PropertyCriteria criteria) {
		LOGGER.info("Property listPropertyByCriteria()");
		List<Property> propertylist = propertyRepository.fetchPropertyByCriteria(criteria.getConfiguration(),
				criteria.getOfferType(), criteria.getCity(), criteria.getMinCost(), criteria.getMaxCost());
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
			mproperty.setBroid(property.getBroker().getUserid());
			mpropertylist.add(mproperty);
		}
		return mpropertylist;
	}
}