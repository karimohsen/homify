package com.homify.de.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContractDao {
	int id;

	int cumstomerId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date startDate;

	String type;

	double revenue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCumstomerId() {
		return cumstomerId;
	}

	public void setCumstomerId(int cumstomerId) {
		this.cumstomerId = cumstomerId;
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

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	
}
