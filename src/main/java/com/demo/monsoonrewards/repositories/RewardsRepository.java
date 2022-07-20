package com.demo.monsoonrewards.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.monsoonrewards.domain.Reward;
import com.demo.monsoonrewards.domain.Transaction;

@Repository
public interface RewardsRepository extends CrudRepository<Reward, Long> {
	Reward findByTransactionId(Transaction transaction);
	@Query(
			value = "SELECT"
			+ "        U.NAME,"
			+ "        MONTH(T.DATE),"
			+ "        SUM(R.POINTS) "
			+ "    FROM"
			+ "        REWARD_TABLE R "
			+ "    INNER JOIN"
			+ "        TRANSACTION_TABLE T "
			+ "            ON R.ID = T.REWARD_ID "
			+ "    INNER JOIN"
			+ "        USER_TABLE U "
			+ "            ON T.USER_ID = U.ID "
			+ "    GROUP BY"
			+ "        U.NAME,"
			+ "        MONTH(T.DATE)",
			nativeQuery = true
		)
	List<String> findMonthlyRewardsPerUser();
}
