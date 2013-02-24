package net.bbenaissa.tassyir.service;

import java.util.Collection;

import net.bbenaissa.tassyir.model.User;

import org.springframework.dao.DataAccessException;

public interface UserService {

	public User findUserById(int id) throws DataAccessException;

	public void saveUser(User user) throws DataAccessException;

	public Collection<User> findUsers() throws DataAccessException;

	Collection<User> findUserByLastName(String lastName)
			throws DataAccessException;
}
