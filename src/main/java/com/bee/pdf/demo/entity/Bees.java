package com.bee.pdf.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String beeName;
	private String email;
	private String mobileNo;
	private Long salary;
	private String doj;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBeeName() {
		return beeName;
	}
	public void setBeeName(String beeName) {
		this.beeName = beeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "Bees [getId()=" + getId() + ", getBeeName()=" + getBeeName() + ", getEmail()=" + getEmail()
				+ ", getMobileNo()=" + getMobileNo() + ", getSalary()=" + getSalary() + ", getDoj()=" + getDoj() + "]";
	}
}
