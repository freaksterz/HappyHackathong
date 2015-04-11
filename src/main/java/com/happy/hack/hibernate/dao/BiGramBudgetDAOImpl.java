package com.happy.hack.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramBudget;
import com.salesorderapp.common.util.HibernateUtil;

public class BiGramBudgetDAOImpl implements BiGramBudgetDAO{

	@Override
	public void addRow(BiGramBudget bl) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(bl);
        transaction.commit();
	}

}
