package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTxAndRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTxAndRestTemplateApplication.class, args);
	}
	
	
	/**
	 * Create Bean for Rest Template to auto 
	 * wire the Rest Template object into our controller.
	 * 
	 * RestTemplate is the central class within the SpringFramework 
	 * for executing synchronous HTTP requests on the client side
	 * 
	 * Spring's REST web-client
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
