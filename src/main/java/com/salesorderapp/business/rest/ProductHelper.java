package com.salesorderapp.business.rest;

import com.salesorderapp.common.util.JSONConverter;
import com.salesorderapp.hibernate.dao.ProductDAOImpl;
import com.salesorderapp.hibernate.entity.Product;

/**
 * Created by freakster on 1/30/2015.
 */
public class ProductHelper {


    String intializeSaveProductEntityBean(String prod){
        Product product= new Product();
        product = (Product) JSONConverter.getEntityObjectFromJSon(prod, product);

        return saveProductEntityBean(product);

    }

    private String saveProductEntityBean(Product product) {
        ProductDAOImpl daoPDImpl = new ProductDAOImpl();
        daoPDImpl.addProduct(product);
        return JSONConverter.getJSONFromEntity(product);
    }
}
