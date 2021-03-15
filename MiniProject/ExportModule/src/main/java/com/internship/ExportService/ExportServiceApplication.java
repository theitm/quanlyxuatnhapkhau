package com.internship.ExportService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.mini_project.CoreModule.entity")
public class ExportServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExportServiceApplication.class, args);
	}

}
