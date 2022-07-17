package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;

import com.demo.monsoonrewards.domain.User;

public interface UserService {
	User addUser(User user);

	List<User> getAllUsers();

	Optional<User> getUserById(final Long id);
	
	User getUserByName(String name);

	void deleteUser(final Long id);

	User updateUser(final Long id, final User user);
}
