package net.bbenaissa.tassyir;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.bbenaissa.tassyir.model.common.BaseEntity;

public class GenericDao<T extends BaseEntity> implements IGenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	public T load(long id) {
		return (T) em.find(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = em.createQuery("FROM " + getEntityClass().getName());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.strator.iris.common.dao.IGenericDao#save(T)
	 */
	public void save(T entity) {
		em.merge(entity);
	}


	public void delete(T entity) {
		em.remove(entity);
	}

	public int delete(Long id) {
		String queryString = " DELETE FROM " + getEntityClass().getName()
				+ " WHERE id = :id ";

		Query query = em.createQuery(queryString);
		query.setParameter("id", id);

		return query.executeUpdate();
	}

	@Override
	public int executeHQLUpdate(String hql) {
		return em.createQuery(hql).executeUpdate();
	}

	@Override
	public void save(T... entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}
}