package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.point_of_sale.checkout.config.ChainsawToolConfig;

@SpringBootApplication
@ConfigurationPropertiesScan("com.point_of_sale")
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ChainsawToolConfig config = context.getBean(ChainsawToolConfig.class);
		// controller.printHello();
	}

}
