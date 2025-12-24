package com.nt.service;

import java.util.List;

import com.nt.entity.FlightDetails;

public interface IFlightMgmtService 
{
	
public String removeFlightByIdsInBatch(List<Integer> ids);	
public List<FlightDetails> showFlightByData(FlightDetails data,boolean ascOrder,String ...prop);

}
