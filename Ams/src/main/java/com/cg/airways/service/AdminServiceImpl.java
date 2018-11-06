package com.cg.airways.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.airways.bean.Admin;
import com.cg.airways.exception.AirwaysException;
import com.cg.airways.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
AdminRepository adminrepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Admin recordsAdd(Admin admin)throws AirwaysException {
		 admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
		Admin ad=adminrepository.save(admin);
		return ad;
	}

	@Override
	public Admin retrive(String userName) throws AirwaysException {

		Admin ad=adminrepository.findOne(userName);
		return ad;
	}
	

}
