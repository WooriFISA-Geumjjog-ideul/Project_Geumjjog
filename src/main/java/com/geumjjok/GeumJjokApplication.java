package com.geumjjok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GeumJjokApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeumJjokApplication.class, args);
	}

}
