package com.example.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.aop.business.BusinessLogic;
import com.example.aop.config.TeamTenantContext;
import com.example.aop.service.TeamService;

@Aspect
public class MyAspect {
	
	@Autowired
	private BusinessLogic businessLogic;
	
	@Around("@annotation(com.example.aop.annotation.LogMethodExecution)")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println();
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		Object result = joinPoint.proceed();
		System.out.println("******");
		System.out.println();
		return result;
	}

	@AfterReturning(pointcut = "execution(* com.example.aop.service.InformationService.displayInformation(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");
		System.out.println();
	}


	@Around("execution(* com.example.aop.service.impl.InformationServiceImpl.getTeamType())")
	public Object logAroundPrivateMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println();
		System.out.println("logAroundPrivateMethod() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		return result;
	}
	

	@Around("get(com.example.aop.service.TeamService com.example.aop..*)")
    public TeamService afterFieldAccess(ProceedingJoinPoint joinPoint) throws Throwable {
		joinPoint.proceed();
		return businessLogic.getService(TeamTenantContext.getTenantId());
    }
    
	
}
