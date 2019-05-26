package com.atguigu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroEureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroEureka7002Application.class, args);
    }
}
