package com.haonguyen.ServiceImport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;


@SpringBootApplication(scanBasePackages = "com.haonguyen.ServiceImport")
@EntityScan(basePackages = "com.mini_project.Coremodule.entity")
public class ServiceImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceImportApplication.class, args);
	}

}
