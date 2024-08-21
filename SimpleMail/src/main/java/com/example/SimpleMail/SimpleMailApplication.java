package com.example.SimpleMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimpleMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMailApplication.class, args);
	}

}
