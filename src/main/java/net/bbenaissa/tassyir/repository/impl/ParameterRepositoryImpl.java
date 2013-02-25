package net.bbenaissa.tassyir.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.bbenaissa.tassyir.model.Parameter;
import net.bbenaissa.tassyir.repository.ParameterRepository;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ParameterRepositoryImpl implements ParameterRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public Parameter findParameterByName(String name)
			throws DataAccessException {
		Query query = this.em
				.createQuery("SELECT parameter FROM Parameter parameter WHERE parameter.name =:name");
		query.setParameter("name", name);
		return (Parameter) query.getSingleResult();
	}

	public Parameter load(Integer id) {
		return (Parameter) em.find(Parameter.class, id);
	}

	public void save(Parameter parameter) {
		em.merge(parameter);
	}

	public void delete(Parameter parameter) {
		em.remove(parameter);
	}

	public Integer delete(Integer id) {
		String queryString = " DELETE FROM Parameter" + " WHERE id = :id ";

		Query query = em.createQuery(queryString);
		query.setParameter("id", id);

		return query.executeUpdate();
	}

	public void save(Parameter... entities) {
		for (Parameter parameter : entities) {
			save(parameter);
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parameter> getAllParameter() {
		Query query = em.createQuery("FROM Parameter ");
		return query.getResultList();
	}

}
