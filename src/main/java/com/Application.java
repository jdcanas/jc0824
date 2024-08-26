package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan("com.point_of_sale")
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
