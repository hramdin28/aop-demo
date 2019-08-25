package com.example.aop.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
@Primary
public class OtherTeamServiceImpl implements TeamService {

	@Override
	public String getAverageFansFacebookPosts() {
		return "Their team's performance";
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
