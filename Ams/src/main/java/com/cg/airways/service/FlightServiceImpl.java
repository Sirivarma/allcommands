package com.cg.airways.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.airways.bean.Flights;
import com.cg.airways.exception.AirwaysException;
import com.cg.airways.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public List<Flights> display() throws AirwaysException {

		List<Flights> flights = flightRepository.findAll();

		return flights;

	}

	@Override
	public Flights addFlight(Flights flight) throws AirwaysException {
		
		Flights flights = flightRepository.save(flight);

		return flights;

	}

	@Override
	public Flights retriveOne(int id)  throws AirwaysException{
		Flights flight=flightRepository.findOne(id);
		return flight;
	}

}
