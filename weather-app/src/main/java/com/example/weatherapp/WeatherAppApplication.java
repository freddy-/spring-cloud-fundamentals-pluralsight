package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
public class WeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Autowired
	private WeatherService service;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("current/weather")
	public String getWeather() {
		return "the current weather is " + service.getWeather();
	}
}
