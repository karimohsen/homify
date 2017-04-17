package com.homify.de.services;

import static com.homify.de.utilities.Utilities.contractsList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

@Path("/contract")
public class ContractServices {

	@GET
	@Path("/getcustomerrevenues")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerRevenues(String customer) {
		try {
			JSONObject obj = new JSONObject(customer);
			int customerId = obj.getInt("customerId");
			double revenues = 0;
			for (int i = 0; i < contractsList.size(); i++) {
				if (contractsList.get(i).getCumstomer().getId() == customerId) {
					revenues += contractsList.get(i).getMonthlyRevenue();
				}
			}
			Response.status(Status.ACCEPTED).build();
			return "{\"revenues\":" + revenues + "}";
		} catch (Exception e) {
			Response.status(Status.BAD_REQUEST).build();
			return "{\"response\":\"false\"}";
		}
	}

	@GET
	@Path("/getrevenuesbytype")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRevenuesByType(String typeJson) {
		try {
			JSONObject obj = new JSONObject(typeJson);
			String type = obj.getString("type");
			if(type == null){
				Response.status(Status.BAD_REQUEST).build();
				return "{\"response\":\"false\"}";
			}
			double revenues = 0;
			for (int i = 0; i < contractsList.size(); i++) {
				if (contractsList.get(i).getType().equals(type)) {
					revenues += contractsList.get(i).getMonthlyRevenue();
				}
			}
			Response.status(Status.ACCEPTED).build();
			return "{\"revenues\":" + revenues + "}";
		} catch (Exception e) {
			Response.status(Status.BAD_REQUEST).build();
			return "{\"response\":\"false\"}";
		}
	}
}
