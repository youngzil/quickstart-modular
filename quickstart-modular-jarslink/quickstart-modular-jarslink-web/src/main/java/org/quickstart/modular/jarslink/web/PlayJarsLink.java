package org.quickstart.modular.jarslink.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="org.quickstart.modular.jarslink")
public class PlayJarsLink {

	public static void main(String[] args) {
		SpringApplication.run(PlayJarsLink.class, args);
	}
	
}