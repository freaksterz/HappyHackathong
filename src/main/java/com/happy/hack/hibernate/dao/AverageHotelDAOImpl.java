package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.AverageHotel;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public class AverageHotelDAOImpl implements AverageHotelDAO {
    @Override
    public void addRow(AverageHotel rw) {

    }

    @Override
    public List<AverageHotel> getAllData() {
    	 Session session = HibernateUtil.getSession();
         Transaction transaction = session.beginTransaction();
         Query query = session.createQuery("from AverageHotel");
         List<AverageHotel> rowList = query.list();
         transaction.commit();
         return rowList;
    }
}
