package net.bbenaissa.tassyir.repository;

import java.util.Collection;
import java.util.List;

import net.bbenaissa.tassyir.model.User;

import org.springframework.dao.DataAccessException;

public interface UserRepository {

	Collection<User> findByLastName(String lastName) throws DataAccessException;

	User findByLogin(String login) throws DataAccessException;

	public User load(Integer id);

	public List<User> getAll();

	public void save(User user);

	public void delete(User user);

	public Integer delete(Integer id);

	public void save(User... entities);

	public void flush();

	public void clear();
}
