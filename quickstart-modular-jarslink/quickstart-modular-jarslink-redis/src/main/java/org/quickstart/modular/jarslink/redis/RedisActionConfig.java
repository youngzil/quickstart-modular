package org.quickstart.modular.jarslink.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisActionConfig {

	@Bean
	public RedisAction getDemoAction() {
		return new RedisAction();
	}
	
}