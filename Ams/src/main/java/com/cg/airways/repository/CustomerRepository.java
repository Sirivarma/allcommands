package com.cg.airways.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airways.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
