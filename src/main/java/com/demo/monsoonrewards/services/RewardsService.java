package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;

import com.demo.monsoonrewards.domain.Reward;

public interface RewardsService {
	
	Reward addReward(final Reward reward);

	List<Reward> getAllRewards();
	
	Optional<Reward> getRewardById(final Long id);

	List<String> getMonthlyRewardsPerUser();
}
