package com.cg.service;

import java.util.List;
import com.cg.pojo.MProperty;
import com.cg.pojo.PropertyCriteria;

public interface IPropertyService {

	public MProperty addProperty(MProperty property, String broId);

	public MProperty editProperty(MProperty property, String broId);

	public List<MProperty> removePropertyById(int propId);

	public List<MProperty> listAllProperties();

	public MProperty viewPropertyById(int propId);

	public List<MProperty> listPropertyByCriteria(PropertyCriteria criteria);

}