package com.cg.airways.service;

import com.cg.airways.bean.Admin;
import com.cg.airways.exception.AirwaysException;

public interface AdminService {
public Admin recordsAdd(Admin admin)throws AirwaysException;
public Admin retrive(String userName)throws AirwaysException;
}
