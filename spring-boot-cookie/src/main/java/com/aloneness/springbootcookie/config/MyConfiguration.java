package com.aloneness.springbootcookie.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportSelector.class)
public class MyConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MyConfiguration1.class);

    @Bean
    public Object test() {
        log.info("MyConfiguration create a object bean...");
        return new Object();
    }

}
