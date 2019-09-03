package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.aop.config.TeamTenantContext;
import com.example.aop.service.InformationService;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);

		InformationService informationService = (InformationService) context.getBean(InformationService.class);

		TeamTenantContext.setTenantId("Liverpool");
		displayInformation(informationService.displayInformation());

		TeamTenantContext.setTenantId("ManchesterUnited");
		displayInformation(informationService.displayInformation());

		TeamTenantContext.setTenantId("Arsenal");
		displayInformation(informationService.displayInformation());

	}

	private static void displayInformation(String information) {

		System.out.println("-------------" + TeamTenantContext.getTenantId() + " Team Information-------------");
		System.out.println(information);
		System.out.println("------------------------------------------");
	}

}
