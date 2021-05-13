package com.cg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cg.pojo.MProperty;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.IPropertyService;

@RestController
@RequestMapping("/property/v1")
public class PropertyController {
	@Autowired
	IPropertyService propertyService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);

	// add property by broker Id
	@PostMapping(path = "/addproperty/{broId}")
	public ResponseEntity<MProperty> addProperty(@Valid @RequestBody MProperty property, @PathVariable String broId) {
		LOGGER.info("Property addProperty()");
		MProperty mproperty = propertyService.addProperty(property, broId);
		return new ResponseEntity<MProperty>(mproperty, HttpStatus.CREATED);
	}

	// to update property by broker Id
	@PutMapping(path = "/updateproperty/{broId}")
	public ResponseEntity<MProperty> editProperty(@Valid @RequestBody MProperty property, @PathVariable String broId) {
		LOGGER.info("Property editProperty()");
		MProperty mproperty = propertyService.editProperty(property, broId);
		return new ResponseEntity<MProperty>(mproperty, HttpStatus.OK);
	}

	// to list all properties
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getallproperties")
	public ResponseEntity<List<MProperty>> listAllProperties() {
		LOGGER.info("Property listAllProperties()");
		List<MProperty> mpropertylist = propertyService.listAllProperties();
		if (mpropertylist.isEmpty()) {
			return new ResponseEntity("Sorry! Property not available!", HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<List<MProperty>>(mpropertylist, HttpStatus.OK);
	}

	// list out all properties by criteria
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getallbycriteria")
	public ResponseEntity<List<MProperty>> listPropertyByCriteria(PropertyCriteria criteria) {
		LOGGER.info("Property listPropertyByCriteria()");
		List<MProperty> mpropertylist = propertyService.listPropertyByCriteria(criteria);
		if (mpropertylist.isEmpty()) {
			return new ResponseEntity("Sorry! Property not available!", HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<List<MProperty>>(mpropertylist, HttpStatus.OK);
	}

	// to search property by propertyId
	@GetMapping(path = "/viewpropertybyid/{propId}")
	public ResponseEntity<MProperty> viewPropertyById(@PathVariable int propId) {
		LOGGER.info("Property viewPropertyById()");
		MProperty mproperty = propertyService.viewPropertyById(propId);
		return new ResponseEntity<MProperty>(mproperty, HttpStatus.OK);
	}

	// to remove property by property Id
	@DeleteMapping(path = "/removepropertybyid/{propId}")
	public ResponseEntity<List<MProperty>> removePropertyById(@PathVariable int propId) {
		LOGGER.info("Property removePropertyById()");
		List<MProperty> mpropertylist = propertyService.removePropertyById(propId);
		return new ResponseEntity<List<MProperty>>(mpropertylist, HttpStatus.OK);
	}
}