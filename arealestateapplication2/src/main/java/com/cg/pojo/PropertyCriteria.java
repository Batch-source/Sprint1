package com.cg.pojo;

public class PropertyCriteria {
	private String configuration;		// Flat/Shop/Plot
	private String offerType;		// Sale/Rent
	private String city;		// Not specified then all
	private double minCost;		// Not specified then 0
	private double maxCost;		// Not specified then max double value
	public String getConfiguration() {
		return configuration;
	}
	public void setConfig(String config) {
		this.configuration = config;
	}
	public String getOfferType() {
		return offerType;
	}
	public void setOffer(String offertype) {
		this.offerType = offertype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getMinCost() {
		return minCost;
	}
	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}
	public double getMaxCost() {
		return maxCost;
	}
	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}
	@Override
	public String toString() {
		return "PropertyCriteria [configuration=" + configuration + ", offerType=" + offerType + ", city=" + city
				+ ", minCost=" + minCost + ", maxCost=" + maxCost + "]";
	}
	public PropertyCriteria(String configuration, String offerType, String city, double minCost, double maxCost) {
		super();
		this.configuration = configuration;
		this.offerType = offerType;
		this.city = city;
		this.minCost = minCost;
		this.maxCost = maxCost;
	}
	public PropertyCriteria() {
		super();
	}
	
}
