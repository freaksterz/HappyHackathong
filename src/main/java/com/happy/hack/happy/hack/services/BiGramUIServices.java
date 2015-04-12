package com.happy.hack.happy.hack.services;


import com.google.gson.JsonObject;
import com.happy.hack.hibernate.dao.BiGramUIBudgetDAOImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;


/**
 * Created by freakster on 12/4/15.
 */
@Path("/BiGrams")
public class BiGramUIServices {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public String getBiGramServices(String req ) {

        System.out.println("req = " + req);


        JSONObject jsonObject = new JSONObject(req);
        //JSONObject abc = (JSONObject)jsonObject.get("jsonObject");
        System.out.println(jsonObject.get("value"));
        String type = jsonObject.get("type").toString();
        float value = Float.parseFloat(jsonObject.get("value").toString());
        float rooms = Float.parseFloat(jsonObject.get("rooms").toString());
        float locations = Float.parseFloat(jsonObject.get("locations").toString());
        float cleanliness = Float.parseFloat(jsonObject.get("cleanliness").toString());
        float checkIn = Float.parseFloat(jsonObject.get("checkIn").toString());
        float service = Float.parseFloat(jsonObject.get("service").toString());
        float bussService = Float.parseFloat(jsonObject.get("bussService").toString());

        //int sleepQuality = Integer.parseInt(req.getParameter("sleepQuality"));


        BiGramUIBudgetDAOImpl biGramUIDAO = new BiGramUIBudgetDAOImpl();
        List<Map<String, String>> list=  biGramUIDAO.getBiGramInteger(value, rooms, locations, cleanliness, checkIn, service, bussService, type);

        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray(list);
        //return Response.ok(biGramUIDAO).build();
        return array.toString();
        //return  Response.ok(array).build();
    }

}
