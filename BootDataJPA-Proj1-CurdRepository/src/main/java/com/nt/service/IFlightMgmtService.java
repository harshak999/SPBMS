package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.FlightDetails;

public interface IFlightMgmtService 
{
	
	public String registerFlight(FlightDetails details);
	public String registerMultipleFlight(List<FlightDetails> details);
	public long showCompanyCount();	
	public boolean isCustomerAvilable(Integer id);
	public Iterable<FlightDetails>  showAllFlghtDetails();
	
	
	public  FlightDetails showFlightDetailsById(int id);
	
	
	//findById()
	
	public Iterable<FlightDetails> viewAllFlightsByID(List<Integer> ids);
	
	public  Optional<FlightDetails> viewFlightDetailsById(int id);	
	public  FlightDetails FlightDetailsById(int id);	
	public String fetchFlightDetailsById(int id);
	public FlightDetails displayFlighById(int id);
	
	public String updateFlightCapacity(int id,double hike);
	public String registerOrUpdateFlightCapacity(FlightDetails detaisl);
	
	//delete object by   Operation
	public String removeFlightById(int id);
	public String removeFlightsByIds(List<Integer> ids);
	public String removeAllFlights();
	
	
	
	

}
