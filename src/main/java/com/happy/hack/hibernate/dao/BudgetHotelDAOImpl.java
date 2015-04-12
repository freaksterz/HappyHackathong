package com.happy.hack.hibernate.dao;

import com.happy.hack.hibernate.entity.BiGramBudget;
import com.happy.hack.hibernate.entity.BudgetHotel;
import com.salesorderapp.common.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by freakster on 11/4/15.
 */
public class BudgetHotelDAOImpl implements BudgetHotelDAO {
    @Override
    public void addRow(BiGramBudget rw) {




    }

    @Override
    public List<BudgetHotel> getAllData() {
    	 Session session = HibernateUtil.getSession();
         Transaction transaction = session.beginTransaction();
         Query query = session.createQuery("from BudgetHotel");
         List<BudgetHotel> rowList = query.list();
         transaction.commit();
         return rowList;
    }
}
