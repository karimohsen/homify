package com.homify.de.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Contract {
	int id;
	
	@JsonBackReference
	Customer cumstomer;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date startDate;

	String type;

	double monthlyRevenue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCumstomer() {
		return cumstomer;
	}

	public void setCumstomer(Customer cumstomer) {
		this.cumstomer = cumstomer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMonthlyRevenue() {
		return monthlyRevenue;
	}

	public void setMonthlyRevenue(double monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}

}
