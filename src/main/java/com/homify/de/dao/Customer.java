package com.homify.de.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Customer {
	int id;

	String fullName;


	@JsonManagedReference
	List<Contract> contracts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
}
