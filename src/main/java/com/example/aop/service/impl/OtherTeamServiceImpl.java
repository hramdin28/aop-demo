package com.example.aop.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
@Primary
public class OtherTeamServiceImpl implements TeamService {

	private String post;
	
	@Override
	public String getAverageFansFacebookPosts() {
		post = "their team's performance";
		return post;
	}

	@Override
	public Boolean isFanGoodPerson() {
		return true;
	}

	@Override
	public Integer getChampionLeagueWins() {
		return 0;
	}

}
