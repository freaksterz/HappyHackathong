package com.hib.annotation;

// Generated 11 Apr, 2015 5:10:44 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Average.
 * @see com.hib.annotation.Average
 * @author Hibernate Tools
 */
@Stateless
public class AverageHome {

	private static final Log log = LogFactory.getLog(AverageHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Average transientInstance) {
		log.debug("persisting Average instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Average persistentInstance) {
		log.debug("removing Average instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Average merge(Average detachedInstance) {
		log.debug("merging Average instance");
		try {
			Average result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Average findById(Integer id) {
		log.debug("getting Average instance with id: " + id);
		try {
			Average instance = entityManager.find(Average.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
