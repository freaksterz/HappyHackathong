// default package
// Generated 28 Dec, 2014 2:51:29 PM by Hibernate Tools 4.0.0

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class SaleOrder.
 * @see .SaleOrder
 * @author Hibernate Tools
 */
@Stateless
public class SaleOrderHome {

	private static final Log log = LogFactory.getLog(SaleOrderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SaleOrder transientInstance) {
		log.debug("persisting SaleOrder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SaleOrder persistentInstance) {
		log.debug("removing SaleOrder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SaleOrder merge(SaleOrder detachedInstance) {
		log.debug("merging SaleOrder instance");
		try {
			SaleOrder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SaleOrder findById(String id) {
		log.debug("getting SaleOrder instance with id: " + id);
		try {
			SaleOrder instance = entityManager.find(SaleOrder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
