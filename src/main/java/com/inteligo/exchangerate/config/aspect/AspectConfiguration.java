package com.inteligo.exchangerate.config.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {

	@Bean
	public LogginAspect loggingAspect(Environment environment) {
		return new LogginAspect(environment);
	}

}
