package com.example.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.annotation.LogMethodExecution;
import com.example.aop.constant.TeamType;
import com.example.aop.service.InformationService;
import com.example.aop.service.TeamService;

@Service
public class InformationServiceImpl implements InformationService {
	
	@Autowired
	private TeamService teamService;

	@LogMethodExecution
	@Override
	public String displayInformation() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Average Fan facebook posts: ");
		builder.append(teamService.getAverageFansFacebookPosts());
		builder.append(System.getProperty("line.separator"));
		builder.append("Champion league wins: ");
		builder.append(teamService.getChampionLeagueWins());
		builder.append(System.getProperty("line.separator"));
		builder.append("TeamType: ");
		builder.append(getTeamType()).toString();
		builder.append(System.getProperty("line.separator"));
		builder.append("Is fan good person: ");
		builder.append(teamService.isFanGoodPerson());
		
		return builder.toString();
	}
	
	private TeamType getTeamType() {
		Integer champWins = teamService.getChampionLeagueWins();
		
		if(champWins >= 5) {
			
			return TeamType.LEGENDARY;
			
		}else if(champWins > 0){
			
			return TeamType.GOOD;
			
		} else {
			
			return TeamType.AVERAGE;
		}
	}

}
