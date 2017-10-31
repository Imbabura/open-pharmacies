package com.pharmaciesopen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan("com.pharmaciesopen")
@EntityScan("com.pharmaciesopen.model")
@EnableJpaRepositories("com.pharmaciesopen")
public class PharmaciesOpenApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PharmaciesOpenApplication.class, args);
	}
	
	@Bean
    public ObjectMapper fooObjectMapper() {
        return new ObjectMapper();
    }
}
