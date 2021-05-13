package com.cg.pojo;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MDeal {
	private int dealId;
	@NotNull(message="Date should not be blank")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dealDate;
	@Min(value=1, message = "Deal cost should be greater than 0")
	private double dealCost;
	private int propid;
	@NotEmpty(message="User Id should not be blank")
	private String userid;
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
	public int getPropid() {
		return propid;
	}
	public void setPropid(int propid) {
		this.propid = propid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public MDeal(int dealId, @NotNull(message = "Date should not be blank") LocalDate dealDate,
			@Min(value = 1, message = "Deal cost should be greater than 0") double dealCost, int propid,
			@NotEmpty(message = "User Id should not be blank") String userid) {
		super();
		this.dealId = dealId;
		this.dealDate = dealDate;
		this.dealCost = dealCost;
		this.propid = propid;
		this.userid = userid;
	}
	public MDeal() {
		super();
	}
	
}
