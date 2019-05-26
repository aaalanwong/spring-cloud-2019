package com.atguigu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroProvider8003Application.class, args);
    }

}

