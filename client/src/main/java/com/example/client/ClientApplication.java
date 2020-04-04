package com.example.client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Autowired
	private EurekaClient client;
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@GetMapping
	public String callService() {
		var restTemplate = restTemplateBuilder.build();
		var instanceInfo = client.getNextServerFromEureka("service", false);
		var baseUrl = instanceInfo.getHomePageUrl();
		var response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);

		return response.getBody();
	}
}
