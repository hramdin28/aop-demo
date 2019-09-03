package com.example.aop.service.impl;

import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
public class LiverpoolServiceImpl implements TeamService {

	private String post;

	@Override
	public String getAverageFansFacebookPosts() {
		post = "their team's past";
		return post;
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
