package com.example.aop.service.impl;

import org.springframework.stereotype.Service;

import com.example.aop.service.TeamService;

@Service
public class ManchesterUnitedServiceImpl implements TeamService {

	private String post;
	@Override
	public String getAverageFansFacebookPosts() {
		post = "Liverpool";
		return post;
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
