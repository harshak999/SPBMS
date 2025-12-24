package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.BootDataJpaProj1PagingAndSortingRepositoryApplication;
import com.nt.entity.FlightDetails;
import com.nt.repository.IFligthtDetailsRepository;


@Service
public class FlightMgmtServiceImpl implements IFlightMgmtService {

    private final BootDataJpaProj1PagingAndSortingRepositoryApplication bootDataJpaProj1CurdRepositoryApplication;

	@Autowired
	private IFligthtDetailsRepository flightRepo;

    FlightMgmtServiceImpl(BootDataJpaProj1PagingAndSortingRepositoryApplication bootDataJpaProj1CurdRepositoryApplication) {
        this.bootDataJpaProj1CurdRepositoryApplication = bootDataJpaProj1CurdRepositoryApplication;
    }

	@Override
	public Iterable<FlightDetails> showFlightAsSorted(boolean ascOrder, String... props) {

		
		//creating Sort Object
		//here we  check ascOrder is true then ASC OR DEC  
		Sort sort=Sort.by(ascOrder ? Sort.Direction.ASC  :  Sort.Direction.DESC , props);
		
		//invoke findAll(sort) method
		Iterable<FlightDetails> it=flightRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<FlightDetails> showFligtByPageoNo(int pageno, int pagesize) {

		//creating pageable object having inputs
		Pageable pageable=PageRequest.of(pageno,pagesize);
	
		//Execute the code
		Page<FlightDetails> page=flightRepo.findAll(pageable);		
		
		return page;
	}

	@Override
	public Page<FlightDetails> showFligtByPageoNoAsSorted(int pageno, int pagesize, boolean ascOrder, String... prop) {

		//creating sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,prop);
		//creating Pageable object having input
		Pageable pageable=PageRequest.of(pageno, pagesize);
		//invoke the method
		Page<FlightDetails> page=flightRepo.findAll(pageable);
		
		
		return page;
	}

	@Override
	public void showFlightByPagination(int pageSize) {
		//get total record
		long count=flightRepo.count();
		
		//decide no.of pages
		Long pageCount=count/pageSize;
		if(count%pageSize!=0)
			pageCount++;
		
		//display records through pagination
		for(int i=0;i<pageCount;i++)
		{
			//creating pageable obj
			Pageable pageable=PageRequest.of(i, pageSize);
			//get each page
			Page<FlightDetails> page=flightRepo.findAll(pageable);
			System.out.println("records of "+(page.getNumber()+1)+"/"+page.getTotalElements());
			page.forEach(System.out::println);
			System.out.println("----------------");
		}
		
	}
	

	

}
