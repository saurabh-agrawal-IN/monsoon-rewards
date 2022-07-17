package com.demo.monsoonrewards.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.monsoonrewards.domain.Transaction;
import com.demo.monsoonrewards.domain.User;
import com.demo.monsoonrewards.repositories.TransactionRepository;
import com.demo.monsoonrewards.repositories.UserRepository;

@SpringBootTest
public class TransactionServiceImplTests {
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Transactional
	public void testAddTransaction() {
		User testUser = new User();
		testUser.setName("Test User");
		userRepository.save(testUser);
		
		Transaction testTransaction = new Transaction();
		testTransaction.setAmount(1200D);
		testTransaction.setDate(new Date());
		testTransaction.setUser(testUser);
		
		Transaction transactionCreated = transactionService.addTransaction(testTransaction);
		assertEquals(transactionCreated.getAmount(), 1200D);
		assertEquals(transactionCreated.getReward().getPoints(), 2250L);		
	}
}
