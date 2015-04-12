package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.AverageHotel;
import com.salesorderapp.common.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public class AverageHotelDAOImpl implements AverageHotelDAO {
    @Override
    public void addRow(AverageHotel averageHotel) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(averageHotel);
        transaction.commit();

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
