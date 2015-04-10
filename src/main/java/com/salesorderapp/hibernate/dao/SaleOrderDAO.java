/**
 * 
 */
package com.salesorderapp.hibernate.dao;

import com.salesorderapp.hibernate.entity.SalesOrder;

import java.util.List;

/**
 * @author freakster
 *
 */
public interface SaleOrderDAO {
	//TODO complete all 
	//TODO define custom Exception handling for the below methods
	//TODO implement generic DAO 
	    
		SalesOrder addSaleOrder(SalesOrder SaleOrder);
		void removeSaleOrder(String oderNumber);
		void updateSaleOrder(SalesOrder SaleOrder);
		void getSaleOrderDetails(String oderNumber);
		
		List<SalesOrder> getAllSaleOrderList(SalesOrder SaleOrder);

}
