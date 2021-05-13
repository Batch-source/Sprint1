package com.cg.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MProperty {
	private int propId;
	@NotEmpty(message="Configuration should not be blank")
	private String configuration;	// Flat/Shop/Plot
	@NotEmpty(message="Offer Type should not be blank")
	private String offerType;	// Sell/Rent
	@Min(value=1, message = "Offer cost should be greater than 0")
	private double offerCost;
	@Min(value=1, message = "Area (in sqft) be greater than 0")
	private double areaSqft;
	@NotEmpty(message="City should not be blank")
	private String city;
	@NotEmpty(message="Address should not be blank")
	private String address;
	@NotEmpty(message="Street should not be blank")
	private String street;
	@NotNull(message="Status should not be blank")
	private boolean status;
	@NotEmpty(message="Broker Id should not be blank")
	private String broid;
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	public double getOfferCost() {
		return offerCost;
	}
	public void setOfferCost(double offerCost) {
		this.offerCost = offerCost;
	}
	public double getAreaSqft() {
		return areaSqft;
	}
	public void setAreaSqft(double areaSqft) {
		this.areaSqft = areaSqft;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBroid() {
		return broid;
	}
	public void setBroid(String broid) {
		this.broid = broid;
	}
	public MProperty(int propId, @NotEmpty(message = "Configuration should not be blank") String configuration,
			@NotEmpty(message = "Offer Type should not be blank") String offerType,
			@Min(value = 1, message = "Offer cost should be greater than 0") double offerCost,
			@Min(value = 1, message = "Area (in sqft) be greater than 0") double areaSqft,
			@NotEmpty(message = "City should not be blank") String city,
			@NotEmpty(message = "Address should not be blank") String address,
			@NotEmpty(message = "Street should not be blank") String street,
			@NotNull(message = "Status should not be blank") boolean status,
			@NotEmpty(message = "Broker Id should not be blank") String broid) {
		super();
		this.propId = propId;
		this.configuration = configuration;
		this.offerType = offerType;
		this.offerCost = offerCost;
		this.areaSqft = areaSqft;
		this.city = city;
		this.address = address;
		this.street = street;
		this.status = status;
		this.broid = broid;
	}
	public MProperty() {
		super();
	}
	
}
