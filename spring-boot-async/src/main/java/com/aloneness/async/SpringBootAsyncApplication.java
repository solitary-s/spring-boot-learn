package com.aloneness.async;

import com.aloneness.async.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tong
 * @create: 2020-04-05 11:34
 */
@SpringBootApplication
public class SpringBootAsyncApplication implements CommandLineRunner {

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAsyncApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testService.test();
    }
}
