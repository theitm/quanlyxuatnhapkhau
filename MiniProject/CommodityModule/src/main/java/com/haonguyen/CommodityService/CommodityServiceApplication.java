package com.haonguyen.CommodityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.mini_project.CoreModule.entity")
@SpringBootApplication
public class CommodityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommodityServiceApplication.class, args);
	}

}
