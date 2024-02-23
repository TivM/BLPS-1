package com.blps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BLPSApplication {
	public static void main(String[] args) {
		SpringApplication.run(BLPSApplication.class, args);
	}

}
