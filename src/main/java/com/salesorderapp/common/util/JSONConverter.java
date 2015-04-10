package com.salesorderapp.common.util;

import com.salesorderapp.hibernate.entity.Customer;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by freakster on 1/30/2015.
 */
public class JSONConverter {

    public static Object getEntityObjectFromJSon(String json, Object entityReference){
        Object entityObject = null;
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(entityReference.getClass());
        try
        {
            entityObject = mapper.readValue(json, entityReference.getClass());
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityObject;
    }

    public static String getJSONFromEntity(Object entityReference) {

        String json =null;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            json = mapper.writeValueAsString(entityReference);
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);
        return json;
    }
}
