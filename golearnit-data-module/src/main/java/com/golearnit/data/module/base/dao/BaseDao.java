package com.golearnit.data.module.base.dao;

/**
 * An interface for DAO objects
 *
 * @author Sadiya Kazi
 *
 * @param <T> the Object instance
 * @param <ID> the primary identifier for the object
 */
public interface BaseDao<T> {

	boolean save(T entity);

	T update(T entity);
}
