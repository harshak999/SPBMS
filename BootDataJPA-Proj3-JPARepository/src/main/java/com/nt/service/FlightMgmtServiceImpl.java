package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.FlightDetails;
import com.nt.repository.IFligthtDetailsRepository;


@Service
public class FlightMgmtServiceImpl implements IFlightMgmtService {

   

	@Autowired
	private IFligthtDetailsRepository flightRepo;

	@Override
	public String removeFlightByIdsInBatch(List<Integer> ids) {
		//use repo
		List<FlightDetails> list=flightRepo.findAllById(ids);
		if(list.size()!=0)
		{
			flightRepo.deleteAllByIdInBatch(ids);
			return list.size()+"no.of records are found to deleted";
		}
		
		
		return "no records are found for deletion";
	}

	@Override
	public List<FlightDetails> showFlightByData(FlightDetails data,boolean ascOrder, String... prop) {

		//create Example object
		Example<FlightDetails> example=Example.of(data);
		//crete sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, prop);
		//use Repo
		List<FlightDetails> list=flightRepo.findAll(example,sort);
		
		return list;
	}


	
	

	

}
 