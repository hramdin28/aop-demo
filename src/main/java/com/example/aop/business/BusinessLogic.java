package com.example.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.aop.service.TeamService;
import com.example.aop.service.impl.LiverpoolServiceImpl;
import com.example.aop.service.impl.ManchesterUnitedServiceImpl;
import com.example.aop.service.impl.OtherTeamServiceImpl;

@Component
public class BusinessLogic {

	@Autowired
	ApplicationContext applicationContext;
	
	public TeamService getService(String teamName) {
		
		if("Liverpool".equalsIgnoreCase(teamName)) {
			
			return applicationContext.getBean(LiverpoolServiceImpl.class);
			
		}else if("ManchesterUnited".equalsIgnoreCase(teamName)) {
			
			return applicationContext.getBean(ManchesterUnitedServiceImpl.class);
			
		}else {
			
			return applicationContext.getBean(OtherTeamServiceImpl.class);
		}

	}
	
}
