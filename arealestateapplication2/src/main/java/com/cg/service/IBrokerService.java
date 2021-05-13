package com.cg.service;

import java.util.List;
import com.cg.pojo.MBroker;
import com.cg.pojo.MProperty;

public interface IBrokerService {

	public MBroker addBroker(MBroker broker);

	public MBroker editBrokerById(MBroker broker, String userid);

	public List<MBroker> removeBrokerById(String broId);

	public MBroker viewBrokerById(String broId);

	public List<MBroker> listAllBrokers();

	public List<MProperty> getAllPropertiesById(String broId);
}