package com.wipro.velocity.model;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Document
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String fname;
	
	private String lname;
	
	@Indexed(unique = true)
	private String email;
	
	private String password;
	
	private Date dob;
	
	private String phone;
	
	private String passportNo;
	
	public User() {
		super();
		
	}
	public User(String fname, String lname, String email, String password, Date dob, String phn, String passportNo) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.phone = phn;
		this.passportNo = passportNo;
	}
	public String getfname() {
		return fname;
	}
	public void setfname(String fName) {
		this.fname = fName;
	}
	public String getlname() {
		return lname;
	}
	public void setlname(String lName) {
		this.lname = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhn() {
		return phone;
	}
	public void setPhn(String phn) {
		this.phone = phn;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
}
