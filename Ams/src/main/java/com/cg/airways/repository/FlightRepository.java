package com.cg.airways.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airways.bean.Flights;

public interface FlightRepository extends JpaRepository<Flights, Integer>{

}
