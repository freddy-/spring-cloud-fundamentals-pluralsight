package com.example.timeapp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimeService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "unknown")
    public String getTime() {
        return restTemplate.getForEntity("http://time-service/time", String.class).getBody();
    }

    public String unknown() {
        return "unknown time";
    }
}
