/**
 * 
 */
package com.salesorderapp.hibernate.dao;

import com.salesorderapp.hibernate.entity.Product;

import java.util.List;

/**
 * @author freakster
 *
 */
public interface ProductDAO {
   //TODO define custom Exception handling for the below methods
   //TODO implement generic DAO 
	Product addProduct(Product product) ;
	void removeProduct(String prodCode);
	void updateProduct(Product product);
	Product getProdcutDetail(String prodCode);
	List<Product> getAllProductList(Product product);
	double getProductPrice(String prodCode);
	
}
