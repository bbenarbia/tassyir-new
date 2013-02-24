package net.bbenaissa.tassyir.service.impl;

import java.util.Collection;

import net.bbenaissa.tassyir.model.User;
import net.bbenaissa.tassyir.repository.UserRepository;
import net.bbenaissa.tassyir.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) throws DataAccessException {
		return userRepository.load(id);
	}

	@Override
	public void saveUser(User user) throws DataAccessException {
		userRepository.save(user);
	}

	@Override
	public Collection<User> findUsers() throws DataAccessException {
		return userRepository.getAll();
	}

	@Override
	public Collection<User> findUserByLastName(String lastName)
			throws DataAccessException {
		return userRepository.findByLastName(lastName);
	}
}
