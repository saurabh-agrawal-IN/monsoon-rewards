package com.demo.monsoonrewards.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.monsoonrewards.domain.Transaction;
import com.demo.monsoonrewards.domain.User;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findByUser(User user);
	List<Transaction> findByDate(Date date);
}
