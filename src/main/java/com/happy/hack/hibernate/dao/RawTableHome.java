package com.hib.annotation;

// Generated 11 Apr, 2015 5:10:44 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class RawTable.
 * @see com.hib.annotation.RawTable
 * @author Hibernate Tools
 */
@Stateless
public class RawTableHome {

	private static final Log log = LogFactory.getLog(RawTableHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RawTable transientInstance) {
		log.debug("persisting RawTable instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RawTable persistentInstance) {
		log.debug("removing RawTable instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RawTable merge(RawTable detachedInstance) {
		log.debug("merging RawTable instance");
		try {
			RawTable result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RawTable findById(Integer id) {
		log.debug("getting RawTable instance with id: " + id);
		try {
			RawTable instance = entityManager.find(RawTable.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
