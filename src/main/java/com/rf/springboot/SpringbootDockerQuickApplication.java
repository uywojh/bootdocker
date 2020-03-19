package com.rf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootDockerQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerQuickApplication.class, args);
    }

}
