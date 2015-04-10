// default package
// Generated 28 Dec, 2014 2:51:29 PM by Hibernate Tools 4.0.0

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class OrderLines.
 * @see .OrderLines
 * @author Hibernate Tools
 */
@Stateless
public class OrderLinesHome {

	private static final Log log = LogFactory.getLog(OrderLinesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OrderLines transientInstance) {
		log.debug("persisting OrderLines instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OrderLines persistentInstance) {
		log.debug("removing OrderLines instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OrderLines merge(OrderLines detachedInstance) {
		log.debug("merging OrderLines instance");
		try {
			OrderLines result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderLines findById(OrderLinesId id) {
		log.debug("getting OrderLines instance with id: " + id);
		try {
			OrderLines instance = entityManager.find(OrderLines.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
