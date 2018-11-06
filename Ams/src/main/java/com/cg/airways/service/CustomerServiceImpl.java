package com.cg.airways.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.airways.bean.Customer;
import com.cg.airways.exception.AirwaysException;
import com.cg.airways.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer1) throws AirwaysException {
		Customer customer = customerRepository.save(customer1);

		return customer;
	}

	@Override
	public List<Customer> display() throws AirwaysException {
		List<Customer> customer = customerRepository.findAll();

		return customer;
	}

}
