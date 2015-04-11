package com.happy.hack.hibernate.dao;


import com.happy.hack.hibernate.entity.RawTable;
import com.salesorderapp.common.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public class RawTableDAOImpl implements RawTableDAO {


    @Override
    public void addRow( RawTable rw) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(rw);
        transaction.commit();
    }

    @Override
    public List<RawTable> getAllData() {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from RawTable");
        List<RawTable> rowList = query.list();
        transaction.commit();
        return rowList;
    }


}
