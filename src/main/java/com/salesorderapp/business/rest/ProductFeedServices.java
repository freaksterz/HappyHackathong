/**
 * 
 */
package com.salesorderapp.business.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author freakster
 *
 */
@Path("/Products")
public class ProductFeedServices {
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
    public String createProduct(String prod) {

		ProductHelper productHelper = new ProductHelper();
		String product = (String) productHelper.intializeSaveProductEntityBean(prod);
		System.out.println(product);
		return product;
    }
}