//FlightDetails.java

package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//This  is OR-Mappingof  object to Db record


@Data
@Table(name="FLIGHT_DETAILS")//Giving Db table name
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class FlightDetails 
{
	@Column(name="FNO")
	@Id//Make it  as primary key Column
	//@GeneratedValue(strategy=GenerationType.AUTO)//Generating  Id values  auto-matically
	//@SequenceGenerator(name="gen1",sequenceName="FNO_SEQ",initialValue=1000,allocationSize=1)
	//@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fno;
	
	@NonNull
	@Column(name="FNAME",length=30)
	private String fname;
	
	@NonNull
	@Column(name="COMPANY",length=30)
	private String company;
	
	@NonNull
	@Column(name="TYPE",length=30)
	private String type;
	
	@NonNull
	//@Transient//it use stop participating in persistance operation
	@Column(name="CAPACITY")//We can not  control  the of  numeric  property 
	private Long capacity;
	
	
	
}
