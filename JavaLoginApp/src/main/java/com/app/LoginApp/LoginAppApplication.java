package com.app.LoginApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages={
		"controller", "config", "dto", "service"})
@EnableJpaRepositories(basePackages="repo")
@EntityScan(basePackages="entity")
public class LoginAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAppApplication.class, args);
	}

}
