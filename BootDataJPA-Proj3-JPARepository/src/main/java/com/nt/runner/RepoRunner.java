package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.FlightDetails;
import com.nt.service.IFlightMgmtService;

@Component
public class RepoRunner implements CommandLineRunner {

	@Autowired	
	private IFlightMgmtService flightService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		/*try
		{
			String msg=flightService.removeFlightByIdsInBatch(List.of(122,20,30));
			System.out.println(msg);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}*/
		
		
		try
		{
			
			FlightDetails details=new FlightDetails();
			details.setType("AirBus");
			details.setCompany("IndiGO");
			List<FlightDetails>list=flightService.showFlightByData(details,true,"capacity");
			list.forEach(System.out::println);		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
