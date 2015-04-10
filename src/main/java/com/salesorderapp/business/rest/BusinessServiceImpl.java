/**
 * 
 */
package com.salesorderapp.business.rest;

import com.salesorderapp.hibernate.dao.CustomerDAOImpl;
import com.salesorderapp.hibernate.entity.Customer;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 * @author freakster
 *
 */


@Path("/create/")
public class BusinessServiceImpl {

	  
	/*  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Path("/customer")
	  public void createCustomer(JsonObject inputJsonObj) throws Exception {

	    String input = (String) inputJsonObj.get("input");
	    String output = "The input you sent is :" + input;
	    JSONObject outputJsonObj = new JSONObject();
	    outputJsonObj.put("output", output);
		Gson gson = new Gson();
		Customer customer = new Customer();
		//Type fooType = new TypeToken<>() {}.getType();
		gson.fromJson(inputJsonObj.toString(), customer.getClass());
		System.out.println(customer);  
        

	  }*/
	  
	  @POST
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("/customer")
	  public Response createCustomer(String json, @Context UriInfo uriInfo) {
		  
	      ObjectMapper mapper = new ObjectMapper();
	      Customer customer = null;
	      try {
	          customer = mapper.readValue(json, Customer.class);
	      }
	      catch (Exception e) {
	          return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	      }
	      CustomerDAOImpl csDAO = new CustomerDAOImpl();
	      csDAO.addCustomer(customer);
	      return Response.ok(csDAO).build(); 
	    		  //(customer, uriInfo);
	  }
	  
	}
	
	

