package com.salesorderapp.business.rest;

import com.salesorderapp.common.util.JSONConverter;
import com.salesorderapp.hibernate.dao.SaleOrderDAOImpl;
import com.salesorderapp.hibernate.entity.SalesOrder;

/**
 * Created by freakster on 3/2/15.
 */
public class SaleOrderHelper {
     String intializeCustomerEntityBean( String sale){

         SalesOrder saleOrder = new SalesOrder();
         saleOrder = (SalesOrder) JSONConverter.getEntityObjectFromJSon(sale, saleOrder);
         SaleOrderDAOImpl saleOrderDAO = new SaleOrderDAOImpl();
         saleOrderDAO.addSaleOrder(saleOrder);
         System.out.println(saleOrder);
         return JSONConverter.getJSONFromEntity(saleOrder);

      }
}
