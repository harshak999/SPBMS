package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.FlightDetails;

public interface IFligthtDetailsRepository extends CrudRepository<FlightDetails, Integer> {

}
