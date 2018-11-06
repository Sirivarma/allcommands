package com.cg.airways.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	private String username;
	private String password;
	private String roles;
	public String getPassword() {
		return password;
	}
	
	@Id		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
	
	
}
