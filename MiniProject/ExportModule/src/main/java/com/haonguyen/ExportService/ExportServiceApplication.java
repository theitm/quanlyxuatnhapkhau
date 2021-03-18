package com.haonguyen.ExportService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.mini_project.CoreModule.entity")
public class ExportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExportServiceApplication.class, args);
	}

}
