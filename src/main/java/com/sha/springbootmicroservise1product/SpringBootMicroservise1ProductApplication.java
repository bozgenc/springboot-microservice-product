package com.sha.springbootmicroservise1product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")

public class SpringBootMicroservise1ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservise1ProductApplication.class, args);
	}

}
