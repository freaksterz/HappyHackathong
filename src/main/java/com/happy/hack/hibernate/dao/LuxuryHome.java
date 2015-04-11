package com.hib.annotation;

// Generated 11 Apr, 2015 5:10:44 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Luxury.
 * @see com.hib.annotation.Luxury
 * @author Hibernate Tools
 */
@Stateless
public class LuxuryHome {

	private static final Log log = LogFactory.getLog(LuxuryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Luxury transientInstance) {
		log.debug("persisting Luxury instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Luxury persistentInstance) {
		log.debug("removing Luxury instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Luxury merge(Luxury detachedInstance) {
		log.debug("merging Luxury instance");
		try {
			Luxury result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Luxury findById(Integer id) {
		log.debug("getting Luxury instance with id: " + id);
		try {
			Luxury instance = entityManager.find(Luxury.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
