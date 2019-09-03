package com.example.aop.config;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.example.aop.aspect.MyAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJConfig{

	/**
	 * Makes the aspect a Spring bean, eligible for receiving autowired components.
	 */
	@Bean
	public MyAspect myAspect() {
		return Aspects.aspectOf(MyAspect.class);
	}



   /* @Bean
    public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        return loadTimeWeaver;
    }*/
}