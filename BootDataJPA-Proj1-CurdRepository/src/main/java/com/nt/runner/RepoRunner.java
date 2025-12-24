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
	private IFlightMgmtService flightrepo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		

		/*try
		{
			
			//Prepare entity Object
			FlightDetails details1=new FlightDetails("5395K1","IndiGO","AirBus",300);
			
			
			
			//Invoke the  service method
			String msg=flightrepo.registerFlight(details1);
			
			
			System.out.println(msg);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		try
		{
			
			//Prepare entity Object
			FlightDetails details1=new FlightDetails("5395K1","IndiGO","AirBus",300L);
			FlightDetails details2=new FlightDetails("5395K2","AirAsia","AirBus",200L);
			FlightDetails details3=new FlightDetails("5395K3","JIO","AirBus",100L);
			FlightDetails details4=new FlightDetails("5395K4","IndiAir","AirBus",300L);
			FlightDetails details5=new FlightDetails("5395K5","AirAsia","AirBus+",250L);
			FlightDetails details6=new FlightDetails("5395K6","JIO2","AirBus",100L);
			
			List<FlightDetails> list=List.of(details1,details2,details3,details4,details5,details6);
		
			
			//Invoke the  service method
			String msg=flightrepo.registerMultipleFlight(list);
			
			
			System.out.println(msg);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		/*	try
			{
				System.out.println("Company count ::"+flightrepo.showCompanyCount());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		
		/*
		try
		{
			boolean flag=flightrepo.isCustomerAvilable(1);
			
			System.out.println(flag);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		
		
		/*try
		{
			
			Iterable<FlightDetails>  it=flightrepo.showAllFlghtDetails();
				
			it.forEach(System.out::println);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		
		/*try
		{
			System.out.println(flightrepo.viewFlightDetailsById(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	
	
	
	
		/*try
		{
			FlightDetails rep=flightrepo.showFlightDetailsById(2);
			
			System.out.println(rep);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	
		
		
		/*try
		{
			System.out.println(flightrepo.fetchFlightDetailsById(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		
		
		
		
		/*try
		{
			Optional<FlightDetails> opt=flightrepo.viewFlightDetailsById(1);
			if(opt.isPresent())
				System.out.println("FlightDetails ::"+opt.get());
			else
				System.out.println(":Flight not found");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		/*try
		{
			FlightDetails ft=flightrepo.FlightDetailsById(2);
			System.out.println(ft);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		/*try
		{
			String msg=flightrepo.fetchFlightDetailsById(111);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		/*try
		{
			FlightDetails msg=flightrepo.displayFlighById(101);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		/*try
		{
			String msg=flightrepo.updateFlightCapacity(1,10.0);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	
		
		
		/*try
		{
			FlightDetails details=new FlightDetails(121,"124Dss","Indigo","AirBuss",100L);
			String msg=flightrepo.registerOrUpdateFlightCapacity(details);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		
		/*try
		{
			
			String msg=flightrepo.removeFlightById(121);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		/*	try
			{
				
				String msg=flightrepo.removeFlightsByIds(List.of(1,4,2, 4));
				System.out.println(msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
	
	
		/*	try
			{
				
				String msg=flightrepo.removeAllFlights();
				System.out.println(msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
	
	}

}
