package com.homify.de.services;

import static com.homify.de.utilities.Utilities.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homify.de.dao.Contract;
import com.homify.de.dao.ContractDao;
import com.homify.de.dao.Customer;
import com.homify.de.dao.CustomerDao;

@Path("/contract")
public class CustomerServices {

	@PUT
	@Path("/addnewcustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addNewCustomer(String customerJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			CustomerDao customerDao = mapper.readValue(customerJson, CustomerDao.class);//map json to customerDao
			List<Contract> contracts = new ArrayList<Contract>();
			Customer customer = new Customer();
			customer.setContracts(contracts);
			customer.setFullName(customerDao.getFullName());
			customer.setId(customerDao.getId());
			customersList.add(customer); // add the customer to customers list with empty contract list
			Response.status(Status.CREATED).build();
			return "{\"response\":\"DONE\"}";

		} catch (Exception e) {
			Response.status(Status.BAD_REQUEST).build();
			return "{\"response\":\"bad input\"}";
		}
	}

	@PUT
	@Path("/addcontracttocustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addContractToCustomer(String contractJson) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ContractDao contractDao = mapper.readValue(contractJson, ContractDao.class);
			boolean found = false;
			Customer customer = null;
			for (int i = 0; i < customersList.size(); i++) {
				if (customersList.get(i).getId() == contractDao.getCumstomerId()) {
					found = true;
					customer = customersList.get(i);
					break;
				}
			}
			if (!found) {
				Response.status(Status.NOT_FOUND).build(); //if the contract with non existing customer id
				return "{\"response\":\"there is no such contact\"}";
			}
			List<Contract> contracts = customer.getContracts();
			Contract contract = new Contract();
			contract.setCumstomer(customer);
			contract.setId(contractDao.getId());
			contract.setMonthlyRevenue(contractDao.getRevenue());
			contract.setStartDate(contractDao.getStartDate());
			contract.setType(contractDao.getType());
			contracts.add(contract);
			contractsList.add(contract);//add contract to contracts list
			customer.setContracts(contracts);//add contract to customer's contracts list
			Response.status(Status.CREATED).build();
			return "{\"response\":\"DONE\"}";
		} catch (Exception e) {
			Response.status(Status.BAD_REQUEST).build();
			return "{\"response\":\"bad input\"}";
		}
	}

	@GET
	@Path("/getallcustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addContractToCustomer() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(contractsList);
			return Response.status(Status.OK).entity(jsonInString).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Couldn't retrive the customers").build();
		}
	}
}
