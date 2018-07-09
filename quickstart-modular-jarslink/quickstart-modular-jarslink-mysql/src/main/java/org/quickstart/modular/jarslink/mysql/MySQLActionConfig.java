package org.quickstart.modular.jarslink.mysql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MySQLActionConfig {
	
	@Bean
	public MySQLAction getDemoAction() {
		return new MySQLAction();
	}
	
}