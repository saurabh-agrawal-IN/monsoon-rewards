package com.demo.monsoonrewards.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.monsoonrewards.domain.Reward;
import com.demo.monsoonrewards.domain.Transaction;

@Repository
public interface RewardsRepository extends CrudRepository<Reward, Long> {
	Reward findByTransactionId(Transaction transaction);
}
