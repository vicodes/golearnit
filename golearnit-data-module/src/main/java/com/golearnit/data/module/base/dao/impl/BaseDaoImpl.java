package com.golearnit.data.module.base.dao.impl;

import com.golearnit.data.module.base.dao.BaseDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * This is a super class of all DAO's in yatra persistence layer and provides implementation of methods lile getUpdatedBy() which are reused
 * across all DAOs
 *
 * @param <T> the entity instance
 * @param <ID> the primary identifier of the entity
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Entity manager factory instance
	 */
	@Autowired
	private EntityManagerFactory entityManagerFactory;


	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public boolean save(T entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean status = false;

		try {
			transaction.begin();

			entityManager.persist(entity);
			status = true;
		} catch (Exception e) {
			logger.error("Exception occured while persisting object of class type : " + entity.getClass().getName(), e);

			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			transaction.commit();
			entityManager.close();
		}

		return status;
	}

	@Override
	public T update(T entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean status = false;

		try {
			transaction.begin();

			entity = entityManager.merge(entity);
			status = true;
			return entity;
		} catch (Exception e) {
			// logger.error("Exception occured while updating object of class type : " + entity.getClass().getName(), e);

			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {
			transaction.commit();
			entityManager.close();
		}

		return null;
	}

}
