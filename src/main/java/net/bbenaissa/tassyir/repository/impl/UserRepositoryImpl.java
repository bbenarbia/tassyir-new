package net.bbenaissa.tassyir.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.bbenaissa.tassyir.model.User;
import net.bbenaissa.tassyir.repository.UserRepository;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl  implements UserRepository {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<User> findByLastName(String lastName)
			throws DataAccessException {
		Query query = this.em
				.createQuery("SELECT user FROM User user WHERE user.lastName LIKE :lastName");
		query.setParameter("lastName", lastName + "%");
		return query.getResultList();
	}

	@Override
	public User findByLogin(String login) throws DataAccessException {
		Query query = this.em
				.createQuery("SELECT user FROM User user WHERE user.login =:login");
		query.setParameter("login", login);
		return (User) query.getSingleResult();
	}
	
	
	
	public User load(Integer id) {
		return (User) em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Query query = em.createQuery("FROM User ");
		return query.getResultList();
	}

	public void save(User user) {
		em.merge(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.strator.iris.common.dao.IGenericDao#delete(T)
	 */
	public void delete(User user) {
		em.remove(user);
	}

	public Integer delete(Integer id) {
		String queryString = " DELETE FROM User" 
				+ " WHERE id = :id ";

		Query query = em.createQuery(queryString);
		query.setParameter("id", id);

		return query.executeUpdate();
	}

//	@Override
//	public int executeHQLUpdate(String hql) {
//		return em.createQuery(hql).executeUpdate();
//	}

	public void save(User... entities) {
		for (User user : entities) {
			save(user);
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

}
