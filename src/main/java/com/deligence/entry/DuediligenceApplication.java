package com.deligence.entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.deligence.controller.FileStorageProperties;


@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories("com.deligence.repository")
@EntityScan("com.deligence.models")
@Configuration

public class DuediligenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuediligenceApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public FileStorageProperties getFileStorage() {

		return new FileStorageProperties();

	}
	

}
