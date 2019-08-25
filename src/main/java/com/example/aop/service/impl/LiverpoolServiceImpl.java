package com.example.aop.service.impl;

import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
public class LiverpoolServiceImpl implements TeamService {

	@Override
	public String getAverageFansFacebookPosts() {
		return "Their team's past";
	}

	@Override
	public Boolean isFanGoodPerson() {
		return true;
	}

	@Override
	public Integer getChampionLeagueWins() {
		return 6;
	}

}
