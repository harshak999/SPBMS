package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.FlightDetails;
import com.nt.repository.IFligthtDetailsRepository;


@Service
public class FlightMgmtServiceImpl implements IFlightMgmtService {

	@Autowired
	private IFligthtDetailsRepository flightRepo;
	
	@Override
	public String registerFlight(FlightDetails details) {
		
		System.out.println("Repo obj class name ::"+flightRepo.getClass()+"...."+Arrays.toString(flightRepo.getClass().getInterfaces()));
		System.out.println("Repo Mehtods: ::"+Arrays.toString(flightRepo.getClass().getMethods()));

		
		//Calling the CrudRepository interface methods using   CrudRepo object  
		//There  are total 12 methods  are there
		FlightDetails saveDetails=flightRepo.save(details);
		int iVal=saveDetails.getFno();

		return "Flight Details are saved with id value ::"+iVal;
	}

	@Override
	public String registerMultipleFlight(List<FlightDetails> details) {
		
		//Use repo
		Iterable<FlightDetails> saveDetails=flightRepo.saveAll(details);
		
	
		//get id values
		List<Integer> ids=StreamSupport.stream(saveDetails.spliterator(),false).map(FlightDetails::getFno).collect(Collectors.toList());
		
		/*	ArrayList<Integer> ids=new ArrayList();
		 saveDetails.forEach(flight->{
			ids.add(flight.getFno());
		});
		*/
		return ids.size()+" no. of flight saved with id values"+ids;
	}

	@Override
	public long showCompanyCount() {

		long count=flightRepo.count();
		
		return count;
	}

	@Override
	public boolean isCustomerAvilable(Integer id) 
	{
		//use repo
		boolean flag=flightRepo.existsById(id);
		return flag;
	}

	@Override
	public Iterable<FlightDetails> showAllFlghtDetails() {
		// TODO Auto-generated method stub
		return flightRepo.findAll();
		}


	@Override
	public FlightDetails showFlightDetailsById(int id) {
		
		FlightDetails details=flightRepo.findById(id).get();

		return details;
	}

	
	@Override
	public Iterable<FlightDetails> viewAllFlightsByID(List<Integer> ids) {

		Iterable<FlightDetails> it=flightRepo.findAllById(ids);
			return it;
	}
	
	

	@Override
	public  Optional<FlightDetails> viewFlightDetailsById(int id) {
          return flightRepo.findById(id);
          }

	

			/*@Override
			public FlightDetails FlightDetailsById(int id) {
			
				Optional<FlightDetails> opt=flightRepo.findById(id);
				if(opt.isPresent())
					return opt.get();
				else
					throw new IllegalArgumentException("Invlaid Id");
			}*/
	
	@Override
	public FlightDetails FlightDetailsById(int id) {
		// If  flight  is  present  the  return  other  return  IllegalArgumentException

		FlightDetails details=flightRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		return details;
	}
	
	@Override
	public String fetchFlightDetailsById(int id) {
		
		Optional<FlightDetails> opt=flightRepo.findById(id);
		if(opt.isEmpty())
			return "FlightDetails not found";
	
		return "Flight details are ::"+opt.get();
	}

	@Override
	public FlightDetails displayFlighById(int id) {
// If  flight  is  present  the  return  other  return  Dummy flightdetails
		FlightDetails details=flightRepo.findById(id).orElse(new FlightDetails("StandBy","AirIndia","AirBus",100L));
		return details;
	}

	@Override
	public String updateFlightCapacity(int id, double hike) {

		
		//here we fins record  and  update the the  record
		//Load object
		Optional<FlightDetails> opt=flightRepo.findById(id);
		if(opt.isPresent())
		{
			FlightDetails detail=opt.get();
			detail.setCapacity(Math.round(detail.getCapacity()+detail.getCapacity()*hike/100.0));
			//update object
			flightRepo.save(detail);
			return "Flight Details are updated";
			}		
		
		return "Flight is not found";
	}

	@Override
	public String registerOrUpdateFlightCapacity(FlightDetails details) {
		// Load Object 
		Optional<FlightDetails> opt=flightRepo.findById(details.getFno());
		if(opt.isPresent())
		{
			
			//update the object
			flightRepo.save(details);
			return details.getFno()+"Flight Details are updated";
		}
		else
		{
			int idVal=flightRepo.save(details).getFno();
			return idVal+"Flight Details are saved";
		}
	}

	@Override
	public String removeFlightById(int id) {
		//Load Object
		Optional<FlightDetails> opt=flightRepo.findById(id);
		if(opt.isPresent()) {
			//Delete the object
			flightRepo.deleteById(id);
		return id+"flight is deleted";
		}	
		else
			return id+"Flight is not Found for deletion";
	}

	@Override
	public String removeFlightsByIds(List<Integer> ids) {
		
		
		//Bulk ids  deletion
		//Load Object
		Iterable<FlightDetails> it=flightRepo.findAllById(ids) ;
	
		long count=StreamSupport.stream(it.spliterator(), false).count();
		if(count!=0) {
			flightRepo.deleteAllById(ids);
			return count+" no.of flight Are deleted";
	}
		return count+"flight are not found  for deletion ";
	}

	@Override
	public String removeAllFlights() {
		//load all Object
		Iterable <FlightDetails> it=flightRepo.findAll();
		long count=StreamSupport.stream(it.spliterator(), false).count();
		if(count!=0)
		{
			flightRepo.deleteAll();
			return count+"no .of records  are deleted";
		}
		else
			return "Table  alredy empty";
		
		

	}

	

}
