package com.happy.hack.happy.hack.services;

import com.happy.hack.hibernate.dao.BiGramUIDAOImpl;
import com.happy.hack.hibernate.entity.BiGram;
import com.happy.hack.hibernate.entity.BiGramUi;
import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 * Created by freakster on 12/4/15.
 */
@Path("/BiGrams")
public class BiGramUIServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/BigramsServices")
    public Response getBiGramServices(String json) {

        /*ObjectMapper mapper = new ObjectMapper();
        BiGram biGram;

        try {
            biGram = mapper.readValue(json, BiGram.class);
        }
        catch (Exception e) {
            return Response.status(ClientResponse.Status.INTERNAL_SERVER_ERROR).build();
        }
        //
        // CustomerDAOImpl csDAO = new CustomerDAOImpl();
        BiGramUIDAOImpl biGramUIDAO = new BiGramUIDAOImpl();

        csDAO.addCustomer(customer);
        return Response.ok(csDAO).build();
        //(customer, uriInfo);*/
        return null;
    }

}
