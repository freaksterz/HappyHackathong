package com.happy.hack.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramAverage;
import com.salesorderapp.common.util.HibernateUtil;

public class BiGramAverageDAOImpl implements BiGramAverageDAO {

	@Override
	public void addRow(BiGramAverage bl) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(bl);
        transaction.commit();
	}

}
