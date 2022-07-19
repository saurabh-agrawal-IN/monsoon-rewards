package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.monsoonrewards.domain.Reward;
import com.demo.monsoonrewards.domain.Transaction;
import com.demo.monsoonrewards.domain.User;
import com.demo.monsoonrewards.repositories.TransactionRepository;
import com.demo.monsoonrewards.repositories.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	private static Double calculateRewards(Double transactionAmount, int pointsAboveFifty, int pointsAboveHundred) {
		return (transactionAmount - 50) * pointsAboveFifty + (transactionAmount - 100) * pointsAboveHundred;
	}

	@Override
	@Transactional
	public Transaction addTransaction(final Transaction transaction) {
		User user = null;
		if (transaction.getUser() != null) {
			String userName = transaction.getUser().getName();
			user = userRepository.findByName(userName);
		}
		if (user != null) {
			transaction.setUser(user);
		}
		Double transAmount = transaction.getAmount();
		Double numberOfRewards = calculateRewards(transAmount, 1, 1);
		Reward reward = new Reward(numberOfRewards.longValue());
		reward.setTransaction(transaction);
		transaction.setReward(reward);
		Transaction transactionDb = transactionRepository.save(transaction);
		user.getTransactions().add(transactionDb);
		userRepository.save(user);
		return transactionDb;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return StreamSupport.stream(transactionRepository.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	}

	@Override
	public Optional<Transaction> getTransactionById(final Long id) {
		return transactionRepository.findById(id);
	}

	@Override
	public List<Transaction> getTransactionsByUserId(final Long id) {
		User user = userService.getUserById(id).get();
		return transactionRepository.findByUser(user);
	}

	@Override
	public List<Transaction> getTransactionsForPeriod(final String fromMonth, final String toMonth) {
		return transactionRepository.findTransactionsForPeriod(fromMonth, toMonth);
	}

	@Override
	public void deleteTransaction(final Long id) {
		Transaction transaction = getTransactionById(id).get();
		transactionRepository.delete(transaction);
	}

	@Override
	public Transaction updateTransaction(final Long id, final Transaction transaction) {
		Transaction transactionDb = getTransactionById(id).get();
		
		if (transaction.getUser() != null) {
			transactionDb.setUser(transaction.getUser());
		}
		
		if (transaction.getReward() != null) {
			transactionDb.setReward(transaction.getReward());
		}
		
		if (transaction.getDate() != null) {
			transactionDb.setDate(transaction.getDate());
		}
		
		if (transaction.getAmount() != 0) {
			transactionDb.setAmount(transaction.getAmount());
		}
		
		return transactionRepository.save(transactionDb);
	}
}
