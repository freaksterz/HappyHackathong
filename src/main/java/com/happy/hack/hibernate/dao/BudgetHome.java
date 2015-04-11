package com.hib.annotation;

// Generated 11 Apr, 2015 5:10:44 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Budget.
 * @see com.hib.annotation.Budget
 * @author Hibernate Tools
 */
@Stateless
public class BudgetHome {

	private static final Log log = LogFactory.getLog(BudgetHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Budget transientInstance) {
		log.debug("persisting Budget instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Budget persistentInstance) {
		log.debug("removing Budget instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Budget merge(Budget detachedInstance) {
		log.debug("merging Budget instance");
		try {
			Budget result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Budget findById(Integer id) {
		log.debug("getting Budget instance with id: " + id);
		try {
			Budget instance = entityManager.find(Budget.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
