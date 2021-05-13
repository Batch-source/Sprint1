package com.cg.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Broker extends User {
	private String broName;
	@OneToMany(targetEntity = Property.class, mappedBy = "broker", fetch = FetchType.LAZY)
	private List<Property> properties = new ArrayList<>();

	public String getBroName() {
		return broName;
	}

	public void setBroName(String broName) {
		this.broName = broName;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
