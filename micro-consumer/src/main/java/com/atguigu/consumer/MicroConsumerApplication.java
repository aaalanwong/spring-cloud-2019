package com.atguigu.consumer;

import com.atguigu.irule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "MICRO-PROVIDER", configuration = MySelfRule.class)
public class MicroConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroConsumerApplication.class, args);
    }

}

