package com.aloneness.springbootcookie.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConfiguration3 {

    private static final Logger log = LoggerFactory.getLogger(MyConfiguration3.class);

    public MyConfiguration3(){
        log.info("MyConfiguration3 construct..." );
    }

    public void execute() {
        log.info("MyConfiguration3 execute...");
    }
}
