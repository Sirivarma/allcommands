package com.cg.airways.service;


import com.cg.airways.bean.Admin;
import com.cg.airways.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.err.println("Normal   "+username);
        Admin admin = adminRepository.findByUsername(username);
System.err.println(admin);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       
       System.err.println("ROLE:::::::::"+admin.getRoles());
        	 grantedAuthorities.add(new SimpleGrantedAuthority(admin.getRoles()));
        

        return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(), grantedAuthorities);
    }
}
