package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;

import com.demo.monsoonrewards.domain.Transaction;

public interface TransactionService {

	Transaction addTransaction(final Transaction transaction);

	List<Transaction> getAllTransactions();

	Optional<Transaction> getTransactionById(final Long id);

	List<Transaction> getTransactionsByUserId(final Long id);

	List<Transaction> getTransactionsForPeriod(final String fromMonth, final String toMonth);
	
	void deleteTransaction(final Long id);

	Transaction updateTransaction(final Long id, final Transaction transaction);

}
