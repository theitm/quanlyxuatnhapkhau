package com.haonguyen.CommodityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan("com.mini_project.CoreModule.entity")
@SpringBootApplication
public class CommodityServiceApplication {
    @Bean

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CommodityServiceApplication.class, args);
    }

}
