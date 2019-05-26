package com.atguigu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //对hystrixR熔断机制的支持
public class MicroProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroProviderHystrixApplication.class, args);
    }

}

