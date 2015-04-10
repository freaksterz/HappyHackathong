/**
 * 
 */
package com.salesorderapp.business.rest;

import com.salesorderapp.common.util.JSONConverter;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author freakster
 *
 */
@Path("/Customers")
public class CustomerFeedServices {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(String cust) {
		CustomerHelper ch = new CustomerHelper();
		String customer = (String) ch.intializeCustomerEntityBean(cust);
		
    	//System.out.println(customer);
		return Response.ok(customer).build();
    }
	
	@GET
	@Path("/{cust_code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(final @PathParam("id") String cust_code) {
		
		CustomerHelper ch = new CustomerHelper();
		String customer = ch.getCustomerDetails(cust_code);
		
		return Response.ok(customer).build();
		
	}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfCustomers() {

        CustomerHelper ch = new CustomerHelper();
        JSONArray listOfCustomers = ch.getAllCustomerDetails();
		//listOfCustomers.
		System.out.println("listOfCustomers = " + listOfCustomers);
		return Response.ok(listOfCustomers).build();

    }

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(final @PathParam("id") String id) {
		CustomerHelper ch = new CustomerHelper();
		ch.deleteCustomer(id);
		return Response.ok().build();
	}



}
