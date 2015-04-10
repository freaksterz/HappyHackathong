package com.salesorderapp.hibernate.dao;

import com.salesorderapp.common.util.HibernateUtil;
import com.salesorderapp.hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOImpl implements ProductDAO{

	public Product addProduct(Product product) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();

        return product;
		
	}

	public void removeProduct(String prodCode) {
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public Product getProdcutDetail(String prodCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAllProductList(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getProductPrice(String prodCode) {
		// TODO Auto-generated method stub
		return 0;
	}

}
