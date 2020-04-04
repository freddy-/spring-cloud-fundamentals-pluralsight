package com.example.timeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeServiceApplication.class, args);
	}

	@GetMapping("time")
	public String getWeather() {
		return LocalDateTime.now().toString();
	}
}
