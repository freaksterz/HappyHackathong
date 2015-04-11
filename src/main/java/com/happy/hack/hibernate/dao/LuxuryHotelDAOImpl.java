package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.LuxuryHotel;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public class LuxuryHotelDAOImpl implements LuxuryHotelDAO {

    @Override
    public void addRow(LuxuryHotel rw) {

    }

    @Override
    public List<LuxuryHotel> getAllData() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from LuxuryHotel");
        List<LuxuryHotel> rowList = query.list();
        transaction.commit();
        return rowList;
    }
}
