package com.example.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	private String[] weather = new String[] {"sunny", "cloudy", "rainy", "windy"};

	@GetMapping("weather")
	public String getWeather() {
		var rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[rand];
	}
}
