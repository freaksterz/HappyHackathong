package com.happy.hack.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.happy.hack.hibernate.entity.BiGramUibudget;
import com.salesorderapp.common.util.HibernateUtil;

public class BiGramUIBudgetDAOImpl implements BiGramUIBudgetDAO {

	@Override
	public void addRow(BiGramUibudget bl) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(bl);
        transaction.commit();
	}

}
