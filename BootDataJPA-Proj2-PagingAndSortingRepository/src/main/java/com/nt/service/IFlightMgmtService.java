package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.FlightDetails;

public interface IFlightMgmtService 
{
	
public 	Iterable<FlightDetails>  showFlightAsSorted(boolean ascOrder,String ...props);//..prop  mean  putting  properties names
public Page<FlightDetails>	 showFligtByPageoNo(int pageno,int pagesize);
public Page<FlightDetails>	 showFligtByPageoNoAsSorted(int pageno,int pagesize,boolean ascOrder,String ...prop);
public void showFlightByPagination(int pageSize);	
	

}
