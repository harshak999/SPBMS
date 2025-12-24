package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
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
			//Iterable<FlightDetails> it=flightService.showFlightAsSorted(true,"company","capacity");
			Iterable<FlightDetails> it=flightService.showFlightAsSorted(true,"fname");
			it.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		/*try
		{
		Page<FlightDetails> page=flightService.showFligtByPageoNo(4, 3); 
		System.out.println("Requested page records are::");	
		page.forEach(System.out::println);
		System.out.println("Current page number::"+page.getNumber());
		System.out.println("Total  page::"+page.getTotalElements());
		System.out.println("Is it  First-page?::"+page.isFirst());
		System.out.println("Is it  Last-page?::"+page.isLast());
		System.out.println("Is  cureent page has next?::"+page.hasNext());
		System.out.println("Is  cureent page has previous page ?::"+page.hasPrevious());
		System.out.println("page Size::"+page.getSize());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		/*try
		{
		Page<FlightDetails> page=flightService.showFligtByPageoNoAsSorted(1, 3,true,"capacity"); 
		System.out.println("Requested page records are::");	
		page.forEach(System.out::println);
		System.out.println("Current page number::"+page.getNumber());
		System.out.println("Total  page::"+page.getTotalElements());
		System.out.println("Is it  First-page?::"+page.isFirst());
		System.out.println("Is it  Last-page?::"+page.isLast());
		System.out.println("Is  cureent page has next?::"+page.hasNext());
		System.out.println("Is  cureent page has previous page ?::"+page.hasPrevious());
		System.out.println("page Size::"+page.getSize());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		
		
		try
		{
			flightService.showFlightByPagination(2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
