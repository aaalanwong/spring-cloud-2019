package com.atguigu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroEureka7003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroEureka7003Application.class, args);
    }
}
