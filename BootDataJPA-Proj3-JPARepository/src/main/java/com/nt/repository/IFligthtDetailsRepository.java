package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.FlightDetails;

public interface IFligthtDetailsRepository extends JpaRepository<FlightDetails, Integer> {

}
