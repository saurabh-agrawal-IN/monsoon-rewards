package com.demo.monsoonrewards.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.monsoonrewards.domain.Transaction;
import com.demo.monsoonrewards.domain.User;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findByUser(User user);
	List<Transaction> findByDate(Date date);
	@Query(
		value = "SELECT * FROM TRANSACTION_TABLE WHERE MONTH(DATE) BETWEEN ?1 AND ?2",
		nativeQuery = true
	)
	List<Transaction> findTransactionsForPeriod(final String fromMonth, final String toMonth);
}
