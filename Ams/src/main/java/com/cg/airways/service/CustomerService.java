package com.cg.airways.service;

import java.util.List;

import com.cg.airways.bean.Customer;
import com.cg.airways.exception.AirwaysException;

public interface CustomerService {
	public Customer addCustomer(Customer customer1) throws AirwaysException;
	public List<Customer> display() throws AirwaysException;

}
