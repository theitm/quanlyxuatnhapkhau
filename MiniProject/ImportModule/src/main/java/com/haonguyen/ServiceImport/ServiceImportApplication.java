package com.haonguyen.ServiceImport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;


@SpringBootApplication(scanBasePackages = "com.haonguyen.ServiceImport")
@EntityScan(basePackages = "com.mini_project.CoreModule.entity")
public class ServiceImportApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceImportApplication.class, args);
	}

}
