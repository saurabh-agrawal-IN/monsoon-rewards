package com.demo.monsoonrewards.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.monsoonrewards.domain.Reward;
import com.demo.monsoonrewards.repositories.RewardsRepository;

@Service
public class RewardsServiceImpl implements RewardsService {
	@Autowired
	RewardsRepository rewardsRepository;

	@Override
	public Reward addReward(final Reward reward) {
		return rewardsRepository.save(reward);
	}
	
	@Override
	public List<Reward> getAllRewards() {
		return StreamSupport.stream(rewardsRepository.findAll().spliterator(), false)
	    .collect(Collectors.toList());
	}
	
	@Override
	public Optional<Reward> getRewardById(final Long id) {
		return rewardsRepository.findById(id);
	}

	@Override
	public List<String> getMonthlyRewardsPerUser() {
		return rewardsRepository.findMonthlyRewardsPerUser();
	}
}
