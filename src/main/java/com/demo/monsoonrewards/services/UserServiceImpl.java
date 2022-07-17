package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.monsoonrewards.domain.User;
import com.demo.monsoonrewards.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(final User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
	    .collect(Collectors.toList());
	}

	@Override
	public Optional<User> getUserById(final Long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public void deleteUser(final Long id) {
		User user = getUserById(id).get();
		userRepository.delete(user);
	}

	@Override
	public User updateUser(final Long id, final User user) {
		User userDb = getUserById(id).get();
		
		if (user.getName() != null && user.getName() != "") {
			userDb.setName(user.getName());
		}
		return userRepository.save(userDb);
	}
}
