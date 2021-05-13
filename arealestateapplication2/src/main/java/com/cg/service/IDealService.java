package com.cg.service;

import java.util.List;
import com.cg.pojo.MDeal;

public interface IDealService {

	public MDeal addDeal(MDeal deal);

	public MDeal viewDealById(int dealId);

	public List<MDeal> listAllDeals();

	public List<MDeal> removeDealById(int dealId);

	public List<MDeal> getAllDealsBycustomerId(String userid);

}