package com.happy.hack.happy.hack.services;

import com.happy.hack.hibernate.dao.BiGramUIDAOImpl;
import com.happy.hack.hibernate.entity.BiGram;
import com.happy.hack.hibernate.entity.BiGramUi;
import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by freakster on 12/4/15.
 */
@Path("/BiGrams")
public class BiGramUIServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/BigramsServices")
    public Response getBiGramServices(HttpServletRequest req, HttpServletResponse res ) {


        String type = req.getParameter("type");
        float value = Float.parseFloat(req.getParameter("value"));
        float rooms = Float.parseFloat(req.getParameter("rooms"));
        float locations = Float.parseFloat(req.getParameter("locations"));
        float cleanliness = Float.parseFloat(req.getParameter("cleanliness"));
        float checkIn = Float.parseFloat(req.getParameter("checkIn"));
        float service = Float.parseFloat(req.getParameter("service"));
        float bussService = Float.parseFloat(req.getParameter("bussService"));
        int sleepQuality = Integer.parseInt(req.getParameter("sleepQuality"));


        BiGramUIDAOImpl biGramUIDAO = new BiGramUIDAOImpl();
        biGramUIDAO.getBiGramInteger(value, rooms, locations, cleanliness, checkIn, service, bussService, sleepQuality);

        return Response.ok(biGramUIDAO).build();
    }

}
