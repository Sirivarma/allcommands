package com.cg.airways.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.airways.bean.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

	Admin findByUsername(String username);

}
