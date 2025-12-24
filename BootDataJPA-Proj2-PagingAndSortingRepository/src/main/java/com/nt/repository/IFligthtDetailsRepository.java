package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.FlightDetails;

public interface IFligthtDetailsRepository extends CrudRepository<FlightDetails, Integer>,PagingAndSortingRepository<FlightDetails, Integer> {

}
