package com.example.ribbontimeapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("time-service")
public interface Client {

    @GetMapping
    String getTime();
}
