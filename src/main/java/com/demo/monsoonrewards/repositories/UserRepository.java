package com.demo.monsoonrewards.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.monsoonrewards.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByName(String name);
}
