/**
 * 
 */
package com.salesorderapp.hibernate.dao;

import com.salesorderapp.common.util.HibernateUtil;
import com.salesorderapp.hibernate.entity.SalesOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author freakster
 *
 */
public class SaleOrderDAOImpl implements SaleOrderDAO{

	public SalesOrder addSaleOrder(SalesOrder saleOrder) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(saleOrder);
        transaction.commit();

        return saleOrder;
		
	}

	public void removeSaleOrder(String oderNumber) {
		// TODO Auto-generated method stub
		
	}

	public void updateSaleOrder(SalesOrder SaleOrder) {
		// TODO Auto-generated method stub
		
	}

	public void getSaleOrderDetails(String oderNumber) {
		// TODO Auto-generated method stub
		
	}

	public List<SalesOrder> getAllSaleOrderList(SalesOrder SaleOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
