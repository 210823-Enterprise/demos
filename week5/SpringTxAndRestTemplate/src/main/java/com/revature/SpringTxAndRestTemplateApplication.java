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

}
