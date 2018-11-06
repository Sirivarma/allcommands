package com.cg.airways.bean;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {
	
	private int customerid;
	@Size(min=3,message="please enter the first name")
	private String firstname;
	
	@Size(min=3,message="please enter the last name")
	private String lastname;
    @NotNull
    @Past(message="date should  not be after today")
	private Date Dateofbirth;
	@NotNull
	private String gender;
	@NotNull
	@Length(max=10,min=10,message="Phone number is not valid.It should be of 10 characters")
	private String phonenumber;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateofbirth() {
		return Dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		Dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", Dateofbirth=" + Dateofbirth + ", gender=" + gender + ", phonenumber=" + phonenumber + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	

}
