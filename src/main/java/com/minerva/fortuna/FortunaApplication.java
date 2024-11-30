package com.minerva.fortuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FortunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunaApplication.class, args);
	}

}
