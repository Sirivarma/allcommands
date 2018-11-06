package com.cg.airways.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Flights {
	
	private int flightNumber;
	@NotNull
	@Size(min=3,message="please enter the flight name")
	private String flightName;
	@NotNull
	@Size(min=3,message="please enter the flight source")
	private String source;
	@NotNull
	@Size(min=3,message="please enter the flight destination")
	private String destination;
	@NotNull
	@Size(min=3,message="please enter the flight arrival time")
	private String arrivalTime;
	@NotNull
	@Size(min=3,message="please enter the flight departure time")
	private String deptTime;
	@NotNull
	@DecimalMin(value = "10.1", inclusive = true)
	@DecimalMax(value = "9999999.9", inclusive = true)
	private BigDecimal price;
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getFlightNumber() {
		return flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Flights [flightNumber=" + flightNumber + ", flightName=" + flightName + ", source=" + source
				+ ", destination=" + destination + ", arrivalTime=" + arrivalTime + ", deptTime=" + deptTime
				+ ", price=" + price + "]";
	}
	
	

}
