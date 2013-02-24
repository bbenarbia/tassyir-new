package net.bbenaissa.tassyir;

import java.util.List;

import net.bbenaissa.tassyir.model.common.BaseEntity;

public interface IGenericDao<T extends BaseEntity> {

	T load(long id);

	List<T> getAll();

	void delete(T entity);

	int delete(Long id);

	int executeHQLUpdate(String hql);

	void save(T entity);

	void save(T... entities);

	void flush();

	void clear();
}