package com.cg.airways.service;

import java.util.List;

import com.cg.airways.bean.Flights;
import com.cg.airways.exception.AirwaysException;

public interface FlightService {
	
	public List<Flights> display() throws AirwaysException;

	public Flights addFlight(Flights flight) throws AirwaysException;
	public Flights retriveOne(int id) throws AirwaysException;
}
