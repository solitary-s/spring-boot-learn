package com.aloneness.spring.boot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootQuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuartzApplication.class, args);
    }
}
