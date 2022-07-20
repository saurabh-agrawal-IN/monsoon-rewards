package com.demo.monsoonrewards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.monsoonrewards.domain.Reward;
import com.demo.monsoonrewards.services.RewardsService;

@RestController
@RequestMapping("monsoon-rewards/v1/rewards")
public class RewardsController {
	@Autowired
	private RewardsService rewardsService;

	@GetMapping
	public List<Reward> getAllRewards() {
		return rewardsService.getAllRewards();
	}
	
    @GetMapping(path = "summary/")
    public List<String> getMonthlyRewardsPerUser() {
    	return rewardsService.getMonthlyRewardsPerUser();
    }
}
