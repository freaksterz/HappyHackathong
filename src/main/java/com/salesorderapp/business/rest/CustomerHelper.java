/**
 * 
 */
package com.salesorderapp.business.rest;


import com.salesorderapp.common.util.JSONConverter;
import com.salesorderapp.hibernate.dao.CustomerDAOImpl;
import com.salesorderapp.hibernate.entity.Customer;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import java.util.List;

/**
 * @author freakster
 *
 */
public class CustomerHelper {

	String custFromDB = null;
	
	public String intializeCustomerEntityBean(String cust) {

		//Customer customer = new Customer();
		Customer customer = new Customer();
		customer = (Customer) JSONConverter.getEntityObjectFromJSon(cust, customer);
		CustomerDAOImpl daoImpl = new CustomerDAOImpl();
		daoImpl.addCustomer(customer);
		System.out.println(customer);
		return JSONConverter.getJSONFromEntity(customer);

	}

	public String getCustomerDetails(String cust_code) {
		CustomerDAOImpl daoImpl = new CustomerDAOImpl();
		//ObjectMapper mapper = new ObjectMapper();
		Customer customer = daoImpl.getCustomerDetails(cust_code);
		String customerJSON = JSONConverter.getJSONFromEntity(customer);
		return customerJSON;
	}

    public JSONArray getAllCustomerDetails() {
        CustomerDAOImpl dao = new CustomerDAOImpl();
        //ObjectMapper mapper = new ObjectMapper();
        List<Customer> customerList = dao.getAllCustomerList();
		JSONArray customerJSONArray = new JSONArray(customerList);
        return customerJSONArray;

    }

	public void deleteCustomer(String id) {
		CustomerDAOImpl dao = new CustomerDAOImpl();
		dao.removeCustomer(id);
	}
}
