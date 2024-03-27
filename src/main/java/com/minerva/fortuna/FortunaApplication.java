package com.minerva.fortuna;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class FortunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunaApplication.class, args);
	}

}
