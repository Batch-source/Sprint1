package com.cg.entity;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Deal {
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEAL_SEQ")
	@SequenceGenerator(sequenceName = "deal_seq", allocationSize = 1, name = "DEAL_SEQ")
	private int dealId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dealDate;	
	private double dealCost;
	@OneToOne(targetEntity = Customer.class, fetch=FetchType.LAZY)
	@JoinColumn
	private Customer customer;
	@JoinColumn
	@OneToOne(targetEntity = Property.class, fetch=FetchType.LAZY)
	private Property property;
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public LocalDate getDealDate() {
		return dealDate;
	}
	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}
	public double getDealCost() {
		return dealCost;
	}
	public void setDealCost(double dealCost) {
		this.dealCost = dealCost;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	@Override
	public String toString() {
		return "Deal [dealId=" + dealId + ", dealDate=" + dealDate + ", dealCost=" + dealCost + ", customer=" + customer
				+ ", property=" + property + "]";
	}
	public Deal() {
		super();
	}
		
}	
