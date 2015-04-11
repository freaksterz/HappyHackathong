package com.happy.hack.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramUiaverage;
import com.salesorderapp.common.util.HibernateUtil;

public class BiGramUIAverageDAOImpl implements BiGramUIAverageDAO {

	@Override
	public void addRow(BiGramUiaverage bl) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(bl);
        transaction.commit();
	}

}
