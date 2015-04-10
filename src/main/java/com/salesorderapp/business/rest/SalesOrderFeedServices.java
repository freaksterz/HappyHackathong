package com.salesorderapp.business.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author freakster
 *
 */
@Path("/SalesOrders")
public class SalesOrderFeedServices {
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
    public String createSaleOrder(String saleOrder) {
        SaleOrderHelper saleOrderHelper = new SaleOrderHelper();
        String customer = (String) saleOrderHelper.intializeCustomerEntityBean(saleOrder);

        //System.out.println(customer);
        return customer;

    }
}