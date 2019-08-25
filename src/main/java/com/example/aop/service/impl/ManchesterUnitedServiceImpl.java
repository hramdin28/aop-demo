package com.example.aop.service.impl;

import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
public class ManchesterUnitedServiceImpl implements TeamService {

	@Override
	public String getAverageFansFacebookPosts() {
		return "Liverpool";
	}

	@Override
	public Boolean isFanGoodPerson() {
		return false;
	}

	@Override
	public Integer getChampionLeagueWins() {
		return 3;
	}


}
